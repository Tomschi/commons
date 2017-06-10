package com.github.tomschi.commons.data.dto.rest;

/**
 * The {@link RESTIdentifiableDto} interface is the base interface for
 * all rest data transfer objects with an identifier.
 *
 * @param <T> The type of the identifier.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface RESTIdentifiableDto<T> extends RESTDataTransferObject {

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
