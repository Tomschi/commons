package com.github.tomschi.commons.data;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {

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
