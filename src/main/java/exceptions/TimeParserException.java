package exceptions;

public class TimeParserException extends Exception {

    public TimeParserException() {
    }

    public TimeParserException(String msg) {
        super(msg);
    }

    public TimeParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
