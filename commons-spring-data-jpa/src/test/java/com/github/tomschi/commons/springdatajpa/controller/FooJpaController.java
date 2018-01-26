package com.github.tomschi.commons.springdatajpa.controller;

import com.github.tomschi.commons.springdatajpa.dbo.FooJpaSequenceDbo;
import com.github.tomschi.commons.springdatajpa.service.FooJpaService;

public class FooJpaController extends AbstractJpaController<FooJpaSequenceDbo, Long, FooJpaService> {

    public FooJpaController(FooJpaService service) {
        super(service);
    }

}
