package com.github.tomschi.commons.data.service;

import com.github.tomschi.commons.data.dbo.PrimaryKeyDbo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * The interface {@link CrudDboService} defines methods for all CRUD operations.
 * The methods are the same as in CrudRepository of the spring framework.
 * One difference is, that an {@link Optional} is returned instead of {@literal null}
 * values.
 *
 * @param <T> The type of the {@link PrimaryKeyDbo}.
 * @param <ID> The id of the {@link PrimaryKeyDbo}.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public interface CrudDboService<T extends PrimaryKeyDbo<ID>, ID extends Serializable> extends CrudService<T> {

    /**
     * Returns a {@link List} of all entities of type {@link T} of the given ids.
     * In case no entity was found an empty {@link List} is returned.
     *
     * @param ids An {@link Iterable} of the ids. Cannot be @{literal null}.
     * @return A {@link List} of entities.
     * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
     */
    List<T> findAllById(Iterable<ID> ids);

    /**
     * Returns the entity of type {@link T} with the given {@code id} of type {@link ID}.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @return An {@link Optional} of the entity.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}.
     */
    Optional<T> findById(ID id);

    /**
     * Checks if a entity of type {@link T} with the given {@code id} of type {@link ID} exists.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @return {@literal true} if the entity exists, else {@literal false}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}.
     */
    boolean existsById(ID id);

    /**
     * Deletes the entity of type {@link T} with the given {@code id} of type {@link ID}.
     *
     * @param id The id of an entity. Cannot be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    void deleteById(ID id);

}