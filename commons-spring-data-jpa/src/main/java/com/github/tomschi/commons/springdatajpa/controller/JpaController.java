package com.github.tomschi.commons.springdatajpa.controller;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import com.github.tomschi.commons.springdata.controller.SortingAndPagingController;
import com.github.tomschi.commons.springdatajpa.service.JpaService;

import java.io.Serializable;

public interface JpaController<T extends DatabaseObject<ID>, ID extends Serializable, S extends JpaService<T, ID>>
        extends SortingAndPagingController<T, ID> {
}
