package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import com.github.tomschi.commons.springdata.service.SortingAndPagingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * The abstract class {@link AbstractJpaCrudService} can be used as base class for
 * a jpa based crud service. It implements crud operations for the given {@link DatabaseObject}.
 *
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The type of the id of the {@link DatabaseObject}.
 * @param <R> The type of the repository.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public abstract class AbstractJpaCrudService<T extends DatabaseObject<ID>, ID extends Serializable, R extends JpaRepository<T, ID>>
        extends AbstractJpaService<R> implements SortingAndPagingService<T, ID> {

    /**
     * Constructor with an repository of type {@link R} as parameter.
     *
     * @param repository A repository of type {@link R}
     */
    public AbstractJpaCrudService(R repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll(Iterable<ID> ids) {
        return getRepository().findAll(ids);
    }

    @Override
    @Transactional
    public List<T> save(Iterable<T> entities) {
        return getRepository().save(entities);
    }

    @Override
    @Transactional
    public Optional<T> save(T entity) {
        return Optional.ofNullable(getRepository().save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findOne(ID id) {
        return Optional.ofNullable(getRepository().findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(ID id) {
        return getRepository().exists(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return getRepository().count();
    }

    @Override
    @Transactional
    public void delete(ID id) {
        getRepository().delete(id);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    @Transactional
    public void delete(Iterable<T> entities) {
        getRepository().delete(entities);
    }

    @Override
    @Transactional
    public void deleteAll() {
        getRepository().deleteAll();
    }

}
