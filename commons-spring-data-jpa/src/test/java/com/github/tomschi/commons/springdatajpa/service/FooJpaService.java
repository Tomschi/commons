package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.springdatajpa.dbo.FooJpaSequenceDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public class FooJpaService extends AbstractJpaService<FooJpaSequenceDbo, Long, JpaRepository<FooJpaSequenceDbo, Long>> {

    public FooJpaService(JpaRepository<FooJpaSequenceDbo, Long> repository) {
        super(repository);
    }

    @Override
    public FooJpaSequenceDbo newInstance() {
        return new FooJpaSequenceDbo();
    }

}
