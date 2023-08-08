package api.backwine.exception;

import io.jsonwebtoken.JwtException;

public class InvalidJwtAuthenticationException extends JwtException {
    public InvalidJwtAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
