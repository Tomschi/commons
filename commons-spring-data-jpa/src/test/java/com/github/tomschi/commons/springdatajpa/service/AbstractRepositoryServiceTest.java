package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.DatabaseObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractRepositoryServiceTest {

    @Mock private JpaRepository<DatabaseObject<Long>, Long> repository;
    @Mock private AbstractRepositoryService<JpaRepository<DatabaseObject<Long>, Long>> service;

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);
        when(service.getRepository()).thenReturn(repository);
    }

    @Test
    void testNullConstructor() {
        assertThrows(IllegalArgumentException.class,
                () -> new AbstractRepositoryService<JpaRepository<DatabaseObject<Long>, Long>>(null){});
    }

    @Test
    void testGetRepository() {
        assertNotNull(new AbstractRepositoryService<JpaRepository<DatabaseObject<Long>, Long>>(repository) {}.getRepository());
    }

}