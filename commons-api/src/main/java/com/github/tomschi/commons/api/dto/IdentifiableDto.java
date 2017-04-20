package com.github.tomschi.commons.api.dto;

/**
 * The {@link IdentifiableDto} interface is the base interface for
 * data transfer objects with an identifier.
 *
 * @param <T> The type of the identifier.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface IdentifiableDto<T> extends DataTransferObject {

    /**
     * The getter of the id.
     *
     * @return The id.
     */
    T getId();

    /**
     * The setter of the id.
     *
     * @param id The new id.
     */
    void setId(T id);

}
