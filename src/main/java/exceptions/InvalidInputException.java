package exceptions;

public class InvalidInputException extends Exception {

    public InvalidInputException() {
    }

    public InvalidInputException(String msg) {
        super(msg);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
