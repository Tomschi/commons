package com.github.tomschi.commons.springdata.controller;

import com.github.tomschi.commons.data.controller.CrudDboController;
import com.github.tomschi.commons.data.dbo.DatabaseObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * The interface {@link SortingAndPagingController} extends the {@link CrudDboController} interface with
 * {@link Pageable} and {@link Sort} methods.
 *
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The id of the {@link DatabaseObject}.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public interface SortingAndPagingController<T extends DatabaseObject<ID>, ID extends Serializable> extends CrudDboController<T, ID> {

    /**
     * Returns a {@link List} of all {@link DatabaseObject}s of type {@link T} sorted by {@link Sort} property.
     * In case no entity was found an empty {@link List} is returned.
     *
     * @param sort A {@link Sort} object.
     * @return A {@link List} of {@link DatabaseObject}s sorted by {@link Sort} property.
     */
    List<T> findAll(Sort sort);

    /**
     * Returns a {@link Page} of {@link DatabaseObject}s ot type {@link T} meeting the paging
     * restriction provided in the {@code Pageable} object. In case no entity was found an empty
     * {@link Page} is returned.
     *
     * @param pageable A {@link Pageable} object.
     * @return A {@link Page} of {@link DatabaseObject}s.
     */
    Page<T> findAll(Pageable pageable);

}
