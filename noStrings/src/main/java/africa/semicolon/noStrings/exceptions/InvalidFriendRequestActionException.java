package africa.semicolon.noStrings.exceptions;

/**
 * Thrown when someone tries to accept/decline a request that isn't
 * PENDING anymore, or tries to friend-request themselves, etc.
 */
public class InvalidFriendRequestActionException extends RuntimeException {
    public InvalidFriendRequestActionException(String message) {
        super(message);
    }
}
