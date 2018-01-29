package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.springdatajpa.dbo.FooJpaSequenceDbo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbstractRepositoryServiceTest {

    @Mock private JpaRepository<FooJpaSequenceDbo, Long> repository;

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testNullConstructor() {
        assertThrows(IllegalArgumentException.class,
                () -> new FooRepositoryService(null));
    }

    @Test
    void testGetRepository() {
        assertNotNull(new FooRepositoryService(repository).getRepository());
    }

}