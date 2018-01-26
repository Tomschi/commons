package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;

import java.io.Serializable;

/**
 * The base interface for a jpa based crud service. It implements crud operations
 * for the given {@link DatabaseObject} but uses the given supertype {@link S} instead.
 *
 *
 * @param <S> The supertype of the {@link DatabaseObject}.
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The type of the id of the {@link DatabaseObject}.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public interface JpaSupertypeService<S extends DatabaseObject<ID>, T extends S, ID extends Serializable> extends JpaService<S, ID> {
}
