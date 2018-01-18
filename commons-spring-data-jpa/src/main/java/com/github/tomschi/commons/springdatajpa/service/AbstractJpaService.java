package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * The abstract class {@link AbstractJpaService} can be used as base class for
 * a jpa based service.
 *
 * @param <R> The type of the repository.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public abstract class AbstractJpaService<R extends JpaRepository<? extends DatabaseObject<? extends Serializable>, ? extends Serializable>> {

    private R repository;

    /**
     * Constructor with an repository of type {@link R} as parameter.
     *
     * @param repository A repository of type {@link R}
     */
    public AbstractJpaService(R repository) {
        Assert.notNull(repository);
        this.repository = repository;
    }

    /**
     * @return A repository of type {@link R}.
     */
    protected R getRepository() {
        return repository;
    }

}
