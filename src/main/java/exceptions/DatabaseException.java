package exceptions;

public class DatabaseException extends Exception {

    public DatabaseException() {
    }

    public DatabaseException(String msg) {
        super(msg);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
