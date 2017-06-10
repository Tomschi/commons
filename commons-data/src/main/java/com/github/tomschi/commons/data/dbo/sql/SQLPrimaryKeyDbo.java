package com.github.tomschi.commons.data.dbo.sql;

/**
 * The interface {@link SQLPrimaryKeyDbo} is the base interface for
 * all SQL based database objects with a primary key.
 *
 * @param <T> The type of the primary key.
 * @since 0.1.0
 * @author Tomschi
 */
public interface SQLPrimaryKeyDbo<T> extends SQLDatabaseObject {

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