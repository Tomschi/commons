package com.github.tomschi.commons.api.dbo;

/**
 * The interface {@link BusinessKeyDbo} is the base interface for
 * database objects with a natural / business key.
 *
 * @param <T> The type of the business key.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface BusinessKeyDbo<T> extends DatabaseObject {

    /**
     * Getter for the business key.
     *
     * @return The business key.
     */
    T getBusinessKey();

    /**
     * Setter of the business key.
     *
     * @param businessKey The new business key.
     */
    void setBusinessKey(T businessKey);

}
