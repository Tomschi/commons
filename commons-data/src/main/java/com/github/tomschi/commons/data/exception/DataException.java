package com.github.tomschi.commons.data.exception;

/**
 * The {@link DataException} is an instance of {@link RuntimeException}.
 * It is the base Exception of data based exceptions.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public class DataException extends RuntimeException {

    private static final long serialVersionUID = 2782128106714692911L;

    /**
     * Constructs a {@link DataException}, where the message is
     * {@literal null}
     */
    public DataException() {
    }

    /**
     * Constructs a {@link DataException} with the given message.
     * @param message The message of the exception.
     */
    public DataException(String message) {
        super(message);
    }

    /**
     * Constructs a {@link DataException} with the given message
     * and cause.
     * @param message The message of the exception.
     * @param cause The cause of the exception.
     */
    public DataException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a {@link DataException} with the given cause,
     * where the message is {@literal null}.
     * @param cause The cause of the exception.
     */
    public DataException(Throwable cause) {
        super(cause);
    }

}
