package com.github.tomschi.commons.data.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * The interface {@link CrudDboService} defines methods for all CRUD operations.
 * The methods are the same as in CrudRepository of the spring framework.
 * One difference is, that an {@link Optional} is returned instead of {@literal null}
 * values.
 *
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The id of the {@link DatabaseObject}.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public interface CrudDboService<T extends DatabaseObject<ID>, ID extends Serializable> {

    /**
     * Returns a {@link List} of all {@link DatabaseObject}s of type {@link T}. In case no entity was found
     * an empty {@link List} is returned.
     *
     * @return A {@link List} of {@link DatabaseObject}s.
     */
    List<T> findAll();

    /**
     * Returns a {@link List} of all {@link DatabaseObject}s of type {@link T} of the given ids.
     * In case no entity was found an empty {@link List} is returned.
     *
     * @param ids An {@link Iterable} of the ids. Cannot be @{literal null}.
     * @return A {@link List} of {@link DatabaseObject}s.
     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
     */
    List<T> findAll(Iterable<ID> ids);

    /**
     * Saves the given {@link DatabaseObject}s of type {@link T} and returns the saved and refreshed entities.
     *
     * @param entities An {@link Iterable} of entities. Cannot be {@literal null}.
     * @return A {@link List} of {@link DatabaseObject}s.
     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
     */
    List<T> save(Iterable<T> entities);

    /**
     * Saves the given {@link DatabaseObject} of type {@link T} and returns the saved and refreshed entity.
     *
     * @param entity The entity to save. Cannot be {@literal null}.
     * @return An {@link Optional} of the saved {@link DatabaseObject}.
     * @throws IllegalArgumentException in case the given {@code entity} is {@literal null}.
     */
    Optional<T> save(T entity);

    /**
     * Returns the {@link DatabaseObject} of type {@link T} with the given {@code id} of type {@link ID}.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @return An {@link Optional} of the {@link DatabaseObject}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}.
     */
    Optional<T> findOne(ID id);

    /**
     * Checks if a {@link DatabaseObject} of type {@link T} with the given {@code id} of type {@link ID} exists.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @return {@literal true} if the {@link DatabaseObject} exists, else {@literal false}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}.
     */
    boolean exists(ID id);

    /**
     * Returns the number of all {@link DatabaseObject}s of type {@link T}.
     *
     * @return The number of all {@link DatabaseObject}s.
     */
    long count();

    /**
     * Deletes the {@link DatabaseObject} of type {@link T} with the given {@code id} of type {@link ID}.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    void delete(ID id);

    /**
     * Deletes the given {@link DatabaseObject} of type {@link T}.
     *
     * @param entity The entity to delete. Cannot be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code entity} is {@literal null}.
     */
    void delete(T entity);

    /**
     * Deletes the given {@link DatabaseObject}s of type {@link T}.
     *
     * @param entities An {@link Iterable} of entities. Cannot be {@literal null}.
     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
     */
    void delete(Iterable<T> entities);

    /**
     * Deletes all {@link DatabaseObject}s of type {@link T}.
     */
    void deleteAll();

}