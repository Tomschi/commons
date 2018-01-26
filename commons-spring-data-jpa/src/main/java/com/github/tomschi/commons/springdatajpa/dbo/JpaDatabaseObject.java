package com.github.tomschi.commons.springdatajpa.dbo;

import com.github.tomschi.commons.data.dbo.DatabaseObject;

import java.io.Serializable;

/**
 * The interface {@link JpaDatabaseObject} is the base interface for
 * all JPA based database objects with a identifier also called primary
 * key.
 *
 * @param <T> The type of the id.
 * @author Tomschi
 * @since 0.1.0
 */
public interface JpaDatabaseObject<T extends Serializable> extends DatabaseObject<T> {
}