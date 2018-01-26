package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.springdatajpa.dbo.FooJpaSequenceDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public class FooRepositoryService extends AbstractRepositoryService<JpaRepository<FooJpaSequenceDbo, Long>> {

    public FooRepositoryService(JpaRepository<FooJpaSequenceDbo, Long> repository) {
        super(repository);
    }

}
