package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import com.github.tomschi.commons.springdata.service.SortingAndPagingService;
import org.springframework.core.ResolvableType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
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

    private final Class<T> T_TYPE_CLASS;

    /**
     * Constructor with an repository of type {@link R} as parameter.
     *
     * @param repository A repository of type {@link R}
     */
    public AbstractJpaInheritCrudService(R repository) {
        super(repository);

        ResolvableType[] resolvableTypes = ResolvableType.forClass(AbstractJpaInheritCrudService.class).getGenerics();
        Assert.notEmpty(resolvableTypes);
        T_TYPE_CLASS = (Class<T>) resolvableTypes[1].getRawClass();
    }

    @Override
    @Transactional(readOnly = true)
    public List<I> findAll() {
        return new ArrayList<>(getRepository().findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<I> findAll(Sort sort) {
        return new ArrayList<>(getRepository().findAll(sort));
    }

    @Override
    @Transactional(readOnly = true)
    public List<I> findAll(Iterable<ID> ids) {
        return new ArrayList<>(getRepository().findAll(ids));
    }

    @Override
    @Transactional
    public List<I> save(Iterable<I> entities) {
        List<T> list = new ArrayList<>();
        for (I it : entities) {
            Assert.isInstanceOf(T_TYPE_CLASS, it);
            list.add(T_TYPE_CLASS.cast(it));
        }
        return new ArrayList<>(getRepository().save(list));
    }

    @Override
    @Transactional
    public Optional<I> save(I entity) {
        Assert.isInstanceOf(T_TYPE_CLASS, entity);
        return Optional.ofNullable(getRepository().save(T_TYPE_CLASS.cast(entity)));
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
        Assert.isInstanceOf(T_TYPE_CLASS, entity);
        getRepository().delete(T_TYPE_CLASS.cast(entity));
    }

    @Override
    @Transactional
    public void delete(Iterable<I> entities) {
        List<T> list = new ArrayList<>();
        for (I it : entities) {
            Assert.isInstanceOf(T_TYPE_CLASS, it);
            list.add(T_TYPE_CLASS.cast(it));
        }
        getRepository().delete(list);
    }

    @Override
    @Transactional
    public void deleteAll() {
        getRepository().deleteAll();
    }

}
