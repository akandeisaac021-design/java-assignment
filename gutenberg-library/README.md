# Gutenberg Library

A small Spring Boot service that exposes a local book catalog backed by the
Project Gutenberg API. It caches results in an H2 database so repeat queries
don't hit the external API every time.

## Stack

- Java 17, Spring Boot 3.3
- Spring Web (`RestClient`) for the outbound Gutenberg API calls
- Spring Data JPA + H2 (file-based) for persistence
- Lombok (`@Getter`/`@Setter`/`@RequiredArgsConstructor`/`@Slf4j`) to cut
  entity/DTO/service boilerplate
- Gradle

## Project layout

```
src/main/java/com/example/gutenberglibrary/
├── entity/Book.java                 # persistence model
├── repository/BookRepository.java   # Spring Data JPA repo (author/subject queries)
├── config/
│   ├── GutenbergApiProperties.java  # binds gutenberg.api.* properties
│   └── RestClientConfig.java        # builds the RestClient bean (base URL + auth headers)
├── dto/                             # external API DTOs + our own response/error DTOs
├── service/
│   ├── GutenbergApiClient.java      # talks to the external API via RestClient
│   └── BookService.java             # cache-first lookup, fetch-then-persist-on-miss
├── controller/BookController.java   # REST endpoints
└── exception/                       # custom exceptions + @RestControllerAdvice handler
```

## The external API

This service is built against the **Project Gutenberg Books API** on
RapidAPI:

- Docs: https://gutenbergapi.com/#documentation
- Host: `project-gutenberg-books-api.p.rapidapi.com`
- Sign up for a free RapidAPI account and subscribe to the free tier at the
  link above to get a key.

Every request to it needs both:

```
X-RapidAPI-Key: <your-api-key>
X-RapidAPI-Host: project-gutenberg-books-api.p.rapidapi.com
```

Its `/api/books` endpoint takes a single general-purpose `q` full-text
parameter (matches title, author, and subjects) — it does **not** expose a
dedicated subject/category filter — which shapes the category-filtering
approach below.

## 1. Setting the API key locally

**No secret is hardcoded anywhere in the repo.** `application.properties` only
references environment variables via `${VAR_NAME:default}` placeholders, and
`RestClientConfig` injects them into the `RestClient` at startup via
`GutenbergApiProperties` (an `@ConfigurationProperties` bean) — the client
code never sees a literal key string.

The base URL and host default to the RapidAPI-hosted API above, so the only
thing you need to set is the key:

```bash
export GUTENBERG_API_KEY="your-rapidapi-key-here"

./gradlew bootRun
```

Or drop it in a local `.env` / IDE run configuration — `.env` is already
git-ignored. `GUTENBERG_API_BASE_URL` and `GUTENBERG_API_HOST` are also
overridable env vars, in case you point this at a different Gutenberg API
provider (self-hosted Gutendex, etc.) with a compatible response shape.

If `GUTENBERG_API_KEY` is left unset, the app still starts, but every call
to the external API will get a `401` from RapidAPI — which this service
surfaces as a `502 Bad Gateway` (see error handling below), rather than
failing at startup.

## 2. Category filtering approach

"Category" here means a Gutenberg **subject**, e.g. `Fiction`,
`Science Fiction`, `Tragedies`.

- Locally, `Book.subjects` stores a book's subjects as a single denormalized
  comma-separated string (rather than a child table), since the only query
  we need against it is a case-insensitive substring match
  (`findBySubjectsContainingIgnoreCase`). That keeps the schema and the
  repository simple — no join needed to answer "does this book match this
  category."
- Against the external API, there's no dedicated subject/topic query param
  to lean on — `/api/books?q=` is a general full-text search that also
  matches titles and author names. So on a cache miss, the category endpoint
  calls `q=<category>`, persists every result returned, then **filters down**
  to the books whose own `subjects` array actually contains the requested
  term before returning — otherwise a search for "Fiction" could also
  return an unrelated book whose *title* happens to contain the word.
- Author search follows the identical pattern for the same reason: `q=` also
  matches titles, so the service post-filters persisted results down to
  books whose author field actually contains the requested name.

## 3. Caching / persistence

Both `GET /api/books/category/{category}` and `GET /api/books/author/{authorName}`
follow the same **cache-first, fetch-then-persist-on-miss** flow, implemented
once in `BookService`:

1. Query the local H2 DB first (`BookRepository`).
2. If there's at least one match, return it immediately — no external call.
3. If there's no local match, call the Gutenberg API via `GutenbergApiClient`.
4. Upsert every result by `gutenbergId` (the entity has a unique constraint
   on it), so re-syncing the same book updates it in place instead of
   duplicating rows.
5. Return the freshly persisted rows (filtered further for the author case,
   as above). If the external API *also* returns nothing, respond `404`.

This means the first request for a given category/author pays the network
cost once; every subsequent request for that same term is served entirely
from the DB. `POST /api/books/sync?q=` runs the same persist step
directly against an arbitrary query, useful for pre-seeding the DB.

H2 is configured as a **file-based** database (`./data/gutenberg`, git-ignored),
so the cache survives app restarts during local development. Swap the
`spring.datasource.*` properties for Postgres/MySQL for anything beyond
local dev.

## Running locally

```bash
./gradlew bootRun
```

> **Lombok + your IDE:** if you open this project in IntelliJ or Eclipse,
> enable annotation processing (IntelliJ: Settings → Build, Execution,
> Deployment → Compiler → Annotation Processors → "Enable annotation
> processing") and install the Lombok plugin if it's not bundled. Without
> that, the IDE will show red squiggles on generated methods like
> `book.getTitle()` even though `./gradlew build` compiles fine, since
> Gradle's own `annotationProcessor` dependency handles it independently of
> the IDE's incremental compiler.

> **First-time note on the Gradle wrapper:** `gradlew`/`gradlew.bat` and
> `gradle/wrapper/gradle-wrapper.properties` are included, but the binary
> `gradle-wrapper.jar` isn't checked in (this environment couldn't reach
> Gradle's servers to fetch it). If `./gradlew` fails with a missing-jar
> error, generate it once with a locally installed Gradle:
> ```bash
> gradle wrapper --gradle-version 8.10
> ```
> or just use your system Gradle directly: `gradle bootRun`.

The app starts on `http://localhost:8080` (override with `PORT`). H2 console
is available at `http://localhost:8080/h2-console` (JDBC URL:
`jdbc:h2:file:./data/gutenberg`).

Build a jar / run tests:

```bash
./gradlew build      # compiles, runs tests, produces build/libs/gutenberg-library-1.0.0.jar
./gradlew test        # tests only
java -jar build/libs/gutenberg-library-1.0.0.jar
```

## Endpoints & curl examples

### GET /api/books/category/{category}

```bash
curl -s http://localhost:8080/api/books/category/Fiction | jq
```

First call fetches from Gutenberg and persists; second call is served from
the DB with no external request.

### GET /api/books/author/{authorName}

```bash
curl -s http://localhost:8080/api/books/author/Dickens | jq
```

### GET /api/books (paginated)

```bash
curl -s "http://localhost:8080/api/books?page=0&size=10&sort=downloadCount,desc" | jq
```

### POST /api/books/sync?q=

```bash
curl -s -X POST "http://localhost:8080/api/books/sync?q=Sherlock%20Holmes" | jq
```

### Error cases

```bash
# No results -> 404
curl -i http://localhost:8080/api/books/category/xyznonexistentsubjectxyz

# Blank input -> 400
curl -i http://localhost:8080/api/books/author/%20

# Upstream Gutenberg API down/unreachable -> 502, e.g. after pointing
# GUTENBERG_API_BASE_URL at an invalid host
curl -i http://localhost:8080/api/books/category/Fiction
```

Every error response has a consistent shape:

```json
{
  "timestamp": "2026-08-20T10:15:30Z",
  "status": 404,
  "error": "Not Found",
  "message": "No books found for category: xyznonexistentsubjectxyz",
  "path": "/api/books/category/xyznonexistentsubjectxyz"
}
```

## Postman

Import `postman/gutenberg-library.postman_collection.json` for ready-made
requests covering all endpoints above, including the error cases.
