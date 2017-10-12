package com.github.tomschi.commons.data.dbo.sql;

import com.github.tomschi.commons.data.dbo.DatabaseObject;

import java.io.Serializable;

/**
 * The interface {@link SQLDatabaseObject} is the base interface for
 * all SQL based database objects with a identifier also called primary
 * key.
 *
 * @param <T> The type of the id.
 * @author Tomschi
 * @since 0.1.0
 */
public interface SQLDatabaseObject<T extends Serializable> extends DatabaseObject<T>, Serializable {
}