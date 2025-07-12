package exceptions;

public class DomainException extends Exception {

    public DomainException() {
    }

    public DomainException(String msg) {
        super(msg);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
