package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import com.github.tomschi.commons.springdata.service.SortingAndPagingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The abstract class {@link AbstractJpaInheritCrudService} can be used as base class
 * for an jpa based crud service.It implements crud operations for the given {@link DatabaseObject}
 * but uses the given interface type {@link I} instead.
 *
 * @param <I> The interface type of the {@link DatabaseObject}
 * @param <T> The type of the {@link DatabaseObject}.
 * @param <ID> The type of the id of the {@link DatabaseObject}.
 * @param <R> The type of the repository.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public abstract class AbstractJpaInheritCrudService<I extends DatabaseObject<ID>, T extends I, ID extends Serializable, R extends JpaRepository<T, ID>>
        extends AbstractJpaService<R> implements SortingAndPagingService<I, ID> {

    private final Class<T> T_TYPE;

    /**
     * Constructor with an repository of type {@link R} as parameter.
     *
     * @param repository A repository of type {@link R}
     */
    public AbstractJpaInheritCrudService(R repository) {
        super(repository);

        // get type name of generic class <T>
        String tTypeName = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1].getTypeName();
        T_TYPE = loadT_Type(tTypeName);
    }

    private Class<T> loadT_Type(String tTypeName) {
        try {
            @SuppressWarnings("unchecked")
            Class<T> t = (Class<T>) Class.forName(tTypeName);
            return t;
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot load class of generic type <T>", e);
        }
    }

    private List<I> castList(List<T> list) {
        @SuppressWarnings("unchecked")
        List<I> result = (List<I>) list;
        return result;
    }

    private List<T> transformList(Iterable<I> iterable) {
        List<T> list = new ArrayList<>();
        for (I it : iterable) {
            Assert.isInstanceOf(T_TYPE, it);
            list.add(T_TYPE.cast(it));
        }
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<I> findAll() {
        return castList(getRepository().findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<I> findAll(Sort sort) {
        return castList(getRepository().findAll(sort));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<I> findAll(Pageable pageable) {
        @SuppressWarnings("unchecked")
        Page<I> page = (Page<I>) getRepository().findAll(pageable);
        return page;
    }

    @Override
    @Transactional(readOnly = true)
    public List<I> findAll(Iterable<ID> ids) {
        return castList(getRepository().findAll(ids));
    }

    @Override
    @Transactional
    public List<I> save(Iterable<I> entities) {
        return castList(getRepository().save(transformList(entities)));
    }

    @Override
    @Transactional
    public Optional<I> save(I entity) {
        Assert.isInstanceOf(T_TYPE, entity);
        return Optional.ofNullable(getRepository().save(T_TYPE.cast(entity)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<I> findOne(ID id) {
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
    public void delete(I entity) {
        Assert.isInstanceOf(T_TYPE, entity);
        getRepository().delete(T_TYPE.cast(entity));
    }

    @Override
    @Transactional
    public void delete(Iterable<I> entities) {
        getRepository().delete(transformList(entities));
    }

    @Override
    @Transactional
    public void deleteAll() {
        getRepository().deleteAll();
    }

}
