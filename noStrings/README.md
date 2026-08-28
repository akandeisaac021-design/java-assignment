# noStrings — MVP

A refactored, runnable Spring Boot version of the project. Scope for this pass: register users and let one user send another a friend request with a short message, which the receiver can accept or decline. Everything else from the original skeleton (Seeker, Preference, matching-by-gender/age search) is kept in the model/repository layer for the next iteration, just cleaned up.

## What changed from the original zip

- **It's now an actual Spring Boot app.** The old `pom.xml` had no Spring dependency at all, and the controllers/`main` method were empty stubs — nothing could run. Added `spring-boot-starter-web`, `spring-boot-starter-validation`, and a real `NoStringsApplication` entry point.
- **Standard Maven layout.** Source moved from `src/africa/semicolon/...` (with a `package semicolon.noStrings...` that didn't even match its folder) to `src/main/java/africa/semicolon/noStrings/...` / `src/test/java/...`, so Maven can actually find and compile it.
- **DTOs are plain data now.** The old `AcceptFriendRequestRequest`/`Response` and `DeclineFriendRequestRequest`/`Response` instantiated repositories and services *inside the DTO* and ran business logic in their constructors. DTOs now only carry data (`RegisterUserRequest`, `SendFriendRequestRequest`, `FriendRequestResponse`, `RegisterUserResponse`, `ApiErrorResponse`); the corresponding logic moved into `UserServiceImpl` / `FriendRequestServiceImpl`. Accept/decline no longer need a request body at all — the id is a path variable (`POST /friend-requests/{id}/accept`), which is simpler to test in Postman.
- **Repositories/services are Spring beans.** `@Repository` / `@Service` + constructor injection, wired automatically instead of every class doing `new XyzRepositoryImpl()` itself (which is what let `Seeker` end up owning a live `UserRepositoryImpl` and a `SeekerServiceImpl` as fields — removed).
- **IDs and relations cleaned up.** `FriendRequest` now stores `senderId`/`receiverId` (Strings) instead of embedding full `Seeker` objects — smaller payloads, no risk of stale nested data. `Seeker` links to `User` via `userId` instead of duplicating password/dob/gender that already live on `User`/`Profile`.
- **Real error handling.** Added `UserNotFoundException`, `DuplicateUserException`, `InvalidAgeException`, `FriendRequestNotFoundException`, `InvalidFriendRequestActionException`, and a `GlobalExceptionHandler` (`@RestControllerAdvice`) so every failure comes back as a consistent JSON body with the right HTTP status instead of a stack trace or silent `null`.
- **Validation on the way in.** `@Valid` + Bean Validation annotations (`@NotBlank`, `@Email`, `@Past`) on the request DTOs, so bad input never reaches a service.
- Business rules enforced: must be 18+ to register, no duplicate email, no self-friending, no duplicate pending requests, can't accept/decline a request that isn't still pending.

## Endpoints (MVP)

| Method | Path | Body | Purpose |
|---|---|---|---|
| POST | `/api/noStrings/register` | `{email, password, firstName, lastName, gender, dob}` | Create a User (+ Profile + Seeker) |
| POST | `/api/noStrings/friend-requests` | `{senderId, receiverId, message}` | Send a friend request with a message |
| POST | `/api/noStrings/friend-requests/{requestId}/accept` | — | Accept as the receiver |
| POST | `/api/noStrings/friend-requests/{requestId}/decline` | — | Decline as the receiver |
| GET | `/api/noStrings/friend-requests/inbox/{userId}` | — | Requests a user has received |
| GET | `/api/noStrings/friend-requests` | — | All requests (debugging) |

`gender` accepts `MALE`, `FEMALE`, `OTHER`. `dob` is `YYYY-MM-DD`.

## Frontend

A full, responsive frontend now lives in `src/main/resources/static` and is served directly by Spring Boot at `http://localhost:8080` — no separate server or build step needed.

| Page | Route | Backed by |
|---|---|---|
| Landing page | `/` (`index.html`) | — (marketing/entry point, links to Sign Up / Sign In) |
| Create account | `/register.html` | `POST /api/noStrings/register` |
| Sign in | `/signin.html` | `GET /api/noStrings/friend-requests/inbox/{userId}` (used to verify the id exists — see note below) |
| Dashboard | `/dashboard.html` | `GET/POST /api/noStrings/friend-requests/*` (Inbox, Send Request, All Requests tabs) |

**Note on "sign in":** the backend doesn't expose a login endpoint (no password check, no lookup-by-email) — the only identifier it hands back is `userId` from `/register`. The frontend treats that `userId` as the access key: it's shown once at sign-up (with a copy button) and typed back in on the Sign In page. This is called out in the UI copy so it isn't mistaken for a real auth system — see "Next steps" below for adding real authentication.

Every button on the dashboard maps to a real backend call:
- **Inbox tab** → `GET /friend-requests/inbox/{userId}`, with **Accept**/**Decline** buttons on each pending card → `POST /friend-requests/{id}/accept` / `/decline`.
- **Send Request tab** → a form (receiver's User ID + optional message) → `POST /friend-requests`.
- **All Requests tab** → `GET /friend-requests`, a read-only feed of every request in the system (useful for demoing/debugging, same as the Postman collection's "list all" step).

All pages are responsive (mobile nav, stacked forms/cards on small screens) and share `static/css/style.css` + `static/js/api.js` (a small fetch wrapper, toast notifications, and a `localStorage`-backed session helper).

## Running it

Requires JDK 21+ and Maven (or use your IDE's built-in Maven).

```bash
mvn spring-boot:run
```

The app starts on `http://localhost:8080` — open that URL in a browser to use the frontend directly (register, sign in, send/accept/decline friend requests). Storage is in-memory (no DB needed for this MVP) — data resets every restart.

## Testing in Postman

Import `noStrings.postman_collection.json` (included at the project root). It's set up to:
1. Register User A → saves the returned `userId` into a collection variable.
2. Register User B → same.
3. User A sends User B a friend request with a message → saves `requestId`.
4. User B checks their inbox.
5. User B accepts (or declines) the request.
6. List all requests to confirm the status changed.

Run the requests top to bottom — each one feeds variables into the next.

## Running the test suite

```bash
mvn test
```

Covers the repositories and, more importantly, the actual send → accept / send → decline flow end-to-end through the service layer (see `FriendRequestServiceImplTest`), plus registration rules (age, duplicate email) in `UserServiceImplTest`.

## Next steps (not in this pass)

- Persistent storage (swap the in-memory `Map`-backed repositories for Spring Data JPA — the interfaces are already the seam for that).
- Real authentication — add a proper `POST /login` (email + password check) so the frontend can stop using `userId` as a stand-in access key, plus hashed passwords (currently stored in plain text — fine for an MVP demo, not for production).
- Wire up the `Preference`/matching search that `ProfileRepositoryImpl.searchForMatches` hinted at, and give it a frontend page (e.g. a "Discover" tab) once it exists.
