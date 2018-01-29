package com.github.tomschi.commons.springdatajpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

/**
 * The abstract class {@link AbstractRepositoryService} can be used as base class for
 * a jpa based service with a {@link JpaRepository}.
 *
 * @param <R> The type of the repository.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public abstract class AbstractRepositoryService<R extends JpaRepository<?, ?>> {

    private final R repository;

    /**
     * Constructor with an repository of type {@link R} as parameter.
     *
     * @param repository A repository of type {@link R}
     */
    public AbstractRepositoryService(R repository) {
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
