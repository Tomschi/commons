package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.SequenceDatabaseObject;
import com.github.tomschi.commons.springdatajpa.dbo.FooJpaSequenceDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public class FooJpaSupertypeService extends AbstractJpaSupertypeService<SequenceDatabaseObject, FooJpaSequenceDbo, Long, JpaRepository<FooJpaSequenceDbo, Long>> {

    public FooJpaSupertypeService(JpaRepository<FooJpaSequenceDbo, Long> repository) {
        super(repository);
    }

    @Override
    public SequenceDatabaseObject newInstance() {
        return new FooJpaSequenceDbo();
    }
}
