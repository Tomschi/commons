package com.github.tomschi.commons.api.dbo;

/**
 * The interface {@link PrimaryKeyDbo} is the base interface for
 * all database objects with a primary key.
 *
 * @param <T> The type of the primary key.
 * @since 0.1.0
 * @author Tomschi
 */
public interface PrimaryKeyDbo<T> extends DatabaseObject {

    /**
     * The getter of the primary key.
     *
     * @return The primary key.
     */
    T getPrimaryKey();

    /**
     * The setter of the primary key.
     *
     * @param primaryKey The new primary key.
     */
    void setPrimaryKey(T primaryKey);

}
