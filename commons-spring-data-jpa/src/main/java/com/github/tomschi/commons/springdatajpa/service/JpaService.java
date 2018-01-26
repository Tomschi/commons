package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import com.github.tomschi.commons.springdata.service.SortingAndPagingService;

import java.io.Serializable;

/**
 * The base interface for a jpa based service. It implements crud operations
 * for the given {@link DatabaseObject}.
 *
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The type of the id of the {@link DatabaseObject}.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public interface JpaService<T extends DatabaseObject<ID>, ID extends Serializable> extends SortingAndPagingService<T, ID> {
}
