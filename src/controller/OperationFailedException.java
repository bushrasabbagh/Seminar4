package controller;

/**
 * Thrown when an operation fails, with the reason unknown.
 */
public class OperationFailedException extends Exception {

    /**
     * Creates a new instance with the specified message and root cause.
     *
     * @param message The exception message.
     * @param cause The exception that caused this exception.
     */
    public OperationFailedException(String message, Exception cause){
        super(message, cause);
    }
}
