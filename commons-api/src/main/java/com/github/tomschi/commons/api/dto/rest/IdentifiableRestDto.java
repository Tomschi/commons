package com.github.tomschi.commons.api.dto.rest;

/**
 * The {@link IdentifiableRestDto} interface is the base interface for
 * all rest data transfer objects with an identifier.
 *
 * @param <T> The type of the identifier.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface IdentifiableRestDto<T> extends RestDto {

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
