package api.backwine.exception;

public class InvalidJwtAuthenticationException extends Exception {
    public InvalidJwtAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
