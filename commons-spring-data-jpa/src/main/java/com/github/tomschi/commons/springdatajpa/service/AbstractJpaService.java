package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * The abstract class {@link AbstractJpaService} can be used as base class for
 * a jpa based crud service. It implements crud operations for the given {@link DatabaseObject}.
 *
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The type of the id of the {@link DatabaseObject}.
 * @param <R> The type of the repository.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public abstract class AbstractJpaService<T extends DatabaseObject<ID>, ID extends Serializable, R extends JpaRepository<T,ID>>
        extends AbstractRepositoryService<R> implements JpaService<T, ID> {

    public AbstractJpaService(R repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllById(Iterable<ID> ids) {
        return getRepository().findAllById(ids);
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
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    @Transactional
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    @Transactional
    public List<T> saveAll(Iterable<T> entities) {
        return getRepository().saveAll(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(ID id) {
        return getRepository().existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return getRepository().count();
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    @Transactional
    public void deleteAll(Iterable<T> entities) {
        getRepository().deleteAll(entities);
    }

    @Override
    @Transactional
    public void deleteAll() {
        getRepository().deleteAll();
    }

}
