package com.github.tomschi.commons.data.dbo;

import com.github.tomschi.commons.data.DataObject;

import java.io.Serializable;

/**
 * The interface {@link DatabaseObject} is the base interface for
 * all database objects.
 *
 * @param <T> The type of the id.
 * @author Tomschi
 * @since 0.1.0
 */
public interface DatabaseObject<T extends Serializable> extends DataObject {

    /**
     * The getter of the id.
     *
     * @return The id.
     */
    T getId();

    /**
     * The setter of the id.
     *
     * @param id The id to set.
     */
    void setId(T id);

}
