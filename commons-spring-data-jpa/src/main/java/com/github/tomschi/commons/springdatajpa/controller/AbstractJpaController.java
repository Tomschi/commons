package com.github.tomschi.commons.springdatajpa.controller;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import com.github.tomschi.commons.springdatajpa.service.JpaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractJpaController<T extends DatabaseObject<ID>, ID extends Serializable, S extends JpaService<T, ID>>
        implements JpaController<T, ID, S> {

    private final S service;

    public AbstractJpaController(S service) {
        Assert.notNull(service, "The given service is null.");
        this.service = service;
    }

    protected S getService() {
        return this.service;
    }

    @Override
    public T newInstance() {
        return getService().newInstance();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getService().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllById(Iterable<ID> ids) {
        return getService().findAllById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll(Sort sort) {
        return getService().findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return getService().findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(ID id) {
        return getService().findById(id);
    }

    @Override
    @Transactional
    public T save(T entity) {
        return getService().save(entity);
    }

    @Override
    @Transactional
    public List<T> saveAll(Iterable<T> entities) {
        return getService().saveAll(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(ID id) {
        return getService().existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return getService().count();
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        getService().deleteById(id);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        getService().delete(entity);
    }

    @Override
    @Transactional
    public void deleteAll(Iterable<T> entities) {
        getService().deleteAll(entities);
    }

    @Override
    @Transactional
    public void deleteAll() {
        getService().deleteAll();
    }

}
