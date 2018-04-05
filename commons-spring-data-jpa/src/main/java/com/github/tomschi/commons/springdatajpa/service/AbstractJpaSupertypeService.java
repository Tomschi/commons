package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The abstract class {@link AbstractJpaSupertypeService} can be used as base class
 * for an jpa based crud service.It implements crud operations for the given {@link DatabaseObject}
 * but uses the given interface type {@link S} instead.
 *
 * @param <S> The supertype of the {@link DatabaseObject}.
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The type of the id of the {@link DatabaseObject}.
 * @param <R> The type of the repository.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public abstract class AbstractJpaSupertypeService<S extends DatabaseObject<ID>, T extends S, ID extends Serializable, R extends JpaRepository<T,ID>>
        extends AbstractRepositoryService<R> implements JpaSupertypeService<S, T, ID> {

    private final Class<T> T_TYPE;

    /**
     * Constructor with an repository of type {@link R} as parameter.
     *
     * @param repository A repository of type {@link R}
     */
    public AbstractJpaSupertypeService(R repository) {
        super(repository);

        @SuppressWarnings("unchecked")
        Class<T> t = (Class<T>) newInstance().getClass();
        T_TYPE = t;
    }

    private List<S> castList(List<T> list) {
        @SuppressWarnings("unchecked")
        List<S> result = (List<S>) list;
        return result;
    }

    private List<T> transformList(Iterable<S> iterable) {
        List<T> list = new ArrayList<>();
        for (S it : iterable) {
            Assert.isInstanceOf(T_TYPE, it);
            list.add(T_TYPE.cast(it));
        }
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<S> findAll() {
        return castList(getRepository().findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<S> findAll(Sort sort) {
        return castList(getRepository().findAll(sort));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<S> findAll(Pageable pageable) {
        @SuppressWarnings("unchecked")
        Page<S> page = (Page<S>) getRepository().findAll(pageable);
        return page;
    }

    @Override
    @Transactional(readOnly = true)
    public List<S> findAllById(Iterable<ID> ids) {
        return castList(getRepository().findAllById(ids));
    }

    @Override
    @Transactional
    public List<S> saveAll(Iterable<S> entities) {
        return castList(getRepository().saveAll(transformList(entities)));
    }

    @Override
    @Transactional
    public S save(S entity) {
        Assert.isInstanceOf(T_TYPE, entity);
        return getRepository().save(T_TYPE.cast(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<S> findById(ID id) {
        return Optional.ofNullable(getRepository().findById(id).get());
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
    public void delete(S entity) {
        Assert.isInstanceOf(T_TYPE, entity);
        getRepository().delete(T_TYPE.cast(entity));
    }

    @Override
    @Transactional
    public void deleteAll(Iterable<S> entities) {
        getRepository().deleteAll(transformList(entities));
    }

    @Override
    @Transactional
    public void deleteAll() {
        getRepository().deleteAll();
    }

}
