package com.github.tomschi.commons.data.dbo;

import com.github.tomschi.commons.data.Identifiable;

import java.io.Serializable;

/**
 * The interface {@link PrimaryKeyDbo} is the base interface for
 * all database objects with primary key.
 *
 * @param <T> The type of the id.
 * @author Tomschi
 * @since 0.2.1
 */
public interface PrimaryKeyDbo<T extends Serializable> extends DatabaseObject, Identifiable<T> {
}
