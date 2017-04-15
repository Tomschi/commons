package com.github.tomschi.commons.api.dbo;

import com.github.tomschi.commons.api.pojo.PrimaryKeyObject;

/**
 * The {@link KeyDatabaseObject} interface is the base interface for
 * all database objects with a primary key.
 *
 * @param <T> The type of the primary key.
 * @since 0.1.0
 * @author Tomschi
 */
public interface KeyDatabaseObject<T> extends DatabaseObject, PrimaryKeyObject<T> {
}
