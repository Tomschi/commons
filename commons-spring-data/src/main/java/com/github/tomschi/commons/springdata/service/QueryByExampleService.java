package com.github.tomschi.commons.springdata.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * The interface {@link QueryByExampleService} extends the {@link SortingAndPagingService} interface with
 * {@link Example} methods.
 *
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The id of the {@link DatabaseObject}.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public interface QueryByExampleService<T extends DatabaseObject<ID>, ID extends Serializable> extends SortingAndPagingService<T, ID> {

    /**
     * Returns a {@link List} of {@link DatabaseObject}s of type {@link T} matching the given {@link Example}.
     * In case no entity was found an empty {@link List} is returned.
     *
     * @param example
     * @return A {@link List} of {@link DatabaseObject}s.
     */
    List<T> findAll(Example<T> example);

    /**
     * Returns a {@link List} of {@link DatabaseObject}s of type {@link T} matching the given {@link Example}
     * and sorted by the given {@link Sort} property. In case no entity was found an empty {@link List} is returned.
     *
     * @param example
     * @param sort
     * @return A {@link List} of {@link DatabaseObject}s.
     */
    List<T> findAll(Example<T> example, Sort sort);

    /**
     * Returns a {@link Page} of {@link T} matching the given {@link Example} meeting the paging restriction
     * provided in the {@code Pageable} object. In case no entity was found an empty {@link Page} is returned.
     *
     * @param example
     * @param pageable
     * @return A {@link Page} of {T}.
     */
    Page<T> findAll(Example<T> example, Pageable pageable);

    /**
     * Returns an {@link Optional} of a {@link DatabaseObject} of type {@link T} matching the given {@link Example}.
     *
     * @param example
     * @return An {@link Optional} of a {@link DatabaseObject}.
     */
    Optional<T> findOne(Example<T> example);

    /**
     * Returns the number of all {@link DatabaseObject}s of type {@link T} matching the given {@link Example}.
     *
     * @param example
     * @return The number of all {@link DatabaseObject}s.
     */
    long count(Example<T> example);

    /**
     * Checks if a {@link DatabaseObject} of type {@link T} matching the given {@link Example} exists.
     *
     * @param example
     * @return {@literal true} if the {@link DatabaseObject} exists, else {@literal false}.
     */
    boolean exists(Example<T> example);

}
