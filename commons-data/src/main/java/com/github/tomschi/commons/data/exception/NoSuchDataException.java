package com.github.tomschi.commons.data.exception;

/**
 * The {@link NoSuchDataException} can be used, when no such data
 * is found.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public class NoSuchDataException extends DataException {

    private static final long serialVersionUID = -6744726460211731785L;

    /**
     * Constructs a {@link DataException}, where the message is
     * {@literal null}
     */
    public NoSuchDataException() {
    }

    /**
     * Constructs a {@link DataException} with the given message.
     * @param message The message of the exception.
     */
    public NoSuchDataException(String message) {
        super(message);
    }

    /**
     * Constructs a {@link DataException} with the given message
     * and cause.
     * @param message The message of the exception.
     * @param cause The cause of the exception.
     */
    public NoSuchDataException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a {@link DataException} with the given cause,
     * where the message is {@literal null}.
     * @param cause The cause of the exception.
     */
    public NoSuchDataException(Throwable cause) {
        super(cause);
    }

}
