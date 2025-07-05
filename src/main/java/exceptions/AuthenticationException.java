package exceptions;

public class AuthenticationException extends Exception {

    public AuthenticationException() {
    }

    public AuthenticationException(String msg) {
        super(msg);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
