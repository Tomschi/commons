package com.github.tomschi.commons.springdata.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import com.github.tomschi.commons.data.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * The interface {@link SortingAndPagingService} extends the {@link CrudService} interface with
 * {@link Pageable} and {@link Sort} methods.
 *
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The id of the {@link DatabaseObject}.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public interface SortingAndPagingService<T extends DatabaseObject<ID>, ID extends Serializable> extends CrudService<T, ID> {

    /**
     * Returns a {@link List} of all {@link DatabaseObject}s of type {@link T} sorted by {@link Sort} property.
     * In case no entity was found an empty {@link List} is returned.
     *
     * @param sort
     * @return A {@link List} of {@link DatabaseObject}s sorted by {@link Sort} property.
     */
    List<T> findAll(Sort sort);

    /**
     * Returns a {@link Page} of {@link DatabaseObject}s ot type {@link T} meeting the paging
     * restriction provided in the {@code Pageable} object. In case no entity was found an empty
     * {@link Page} is returned.
     *
     * @param pageable
     * @return A {@link Page} of {@link DatabaseObject}s
     */
    Page<T> findAll(Pageable pageable);

}
