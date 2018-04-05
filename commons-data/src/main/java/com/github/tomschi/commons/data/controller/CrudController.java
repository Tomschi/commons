package com.github.tomschi.commons.data.controller;

import com.github.tomschi.commons.data.DataObject;
import com.github.tomschi.commons.data.service.CrudService;

import java.util.List;

/**
 * The interface {@link CrudController} defines methods for all CRUD operations.
 * The methods are the same as in {@link CrudService}.
 *
 * @param <T> The type of the {@link DataObject}.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public interface CrudController<T extends DataObject> {

    /**
     * @return A new instance of type {@link T}.
     */
    T newInstance();

    /**
     * Returns a {@link List} of all objects of type {@link T}. In case no entity was found
     * an empty {@link List} is returned.
     *
     * @return A {@link List} of objects.
     */
    List<T> findAll();

    /**
     * Saves the given entities of type {@link T} and returns the saved and refreshed entities.
     *
     * @param entities An {@link Iterable} of entities. Cannot be {@literal null}.
     * @return A {@link List} of entities of type {@link T}.
     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
     */
    List<T> saveAll(Iterable<T> entities);

    /**
     * Saves the given entity of type {@link T} and returns the saved and refreshed entity.
     *
     * @param entity The entity to save. Cannot be {@literal null}.
     * @return The saved entity. Cannot be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code entity} is {@literal null}.
     */
    T save(T entity);

    /**
     * Returns the number of all entities of type {@link T}.
     *
     * @return The number of all entities.
     */
    long count();

    /**
     * Deletes the given entity of type {@link T}.
     *
     * @param entity The entity to delete. Cannot be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code entity} is {@literal null}.
     */
    void delete(T entity);

    /**
     * Deletes the given entities of type {@link T}.
     *
     * @param entities An {@link Iterable} of entities. Cannot be {@literal null}.
     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
     */
    void deleteAll(Iterable<T> entities);

    /**
     * Deletes all entities of type {@link T}.
     */
    void deleteAll();

}
