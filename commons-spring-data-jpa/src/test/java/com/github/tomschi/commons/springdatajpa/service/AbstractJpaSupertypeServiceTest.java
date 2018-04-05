package com.github.tomschi.commons.springdatajpa.service;

import com.github.tomschi.commons.data.dbo.SequenceDatabaseObject;
import com.github.tomschi.commons.springdatajpa.dbo.BarJpaSequenceDbo;
import com.github.tomschi.commons.springdatajpa.dbo.FooJpaSequenceDbo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbstractJpaSupertypeServiceTest {

    @Mock private JpaRepository<FooJpaSequenceDbo, Long> repository;
    @Mock private Page<FooJpaSequenceDbo> page;
    @Mock private Pageable pageable;
    @Mock private Sort sort;

    private FooJpaSupertypeService service;
    private FooJpaSequenceDbo databaseObject1 = new FooJpaSequenceDbo(1L);
    private FooJpaSequenceDbo databaseObject2 = new FooJpaSequenceDbo(2L);
    private BarJpaSequenceDbo databaseObject3 = new BarJpaSequenceDbo(3L);
    private List<FooJpaSequenceDbo> dboList = Arrays.asList(databaseObject1, databaseObject2);
    private List<SequenceDatabaseObject> seqDboList = Arrays.asList(databaseObject1, databaseObject2);

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);

        service = new FooJpaSupertypeService(repository);

        when(page.getContent()).thenReturn(dboList);

        when(repository.findAll()).thenReturn(dboList);
        when(repository.findAll(any(Sort.class))).thenReturn(dboList);
        when(repository.findAllById(anyList())).thenReturn(dboList);
        when(repository.findAll(any(Pageable.class))).thenReturn(page);

        when(repository.save(any(FooJpaSequenceDbo.class))).then(returnsFirstArg());
        when(repository.saveAll(anyList())).then(returnsFirstArg());

        when(repository.findById(anyLong())).thenReturn(Optional.of(databaseObject1));

        when(repository.existsById(anyLong())).thenReturn(false);
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.existsById(2L)).thenReturn(true);

        when(repository.count()).thenReturn(Integer.valueOf(seqDboList.size()).longValue());
    }

    @Test
    void testFindAll() {
        assertEquals(2, service.findAll().size());
        assertEquals(2, service.findAll(sort).size());
        assertEquals(2, service.findAllById(new ArrayList<>(0)).size());
        assertEquals(2, service.findAll(pageable).getContent().size());
    }

    @Test
    void testSave() {
        assertEquals(databaseObject1.getId(), service.save(databaseObject1).getId());
        assertEquals(2, service.saveAll(seqDboList).size());

        assertThrows(IllegalArgumentException.class, () -> service.save(databaseObject3));
        assertThrows(IllegalArgumentException.class, () -> service.saveAll(Collections.singletonList(databaseObject3)));
    }

    @Test
    void testFindOne() {
        assertEquals(databaseObject1, service.findById(1L).orElse(databaseObject2));
    }

    @Test
    void testExists() {
        assertTrue(service.existsById(1L));
        assertTrue(service.existsById(2L));
        assertFalse(service.existsById(100L));
    }

    @Test
    void testCount() {
        assertEquals(Integer.valueOf(dboList.size()).longValue(), service.count());
    }

    @Test
    void testDelete() {
        service.deleteById(1L);
        service.delete(databaseObject1);
        service.deleteAll(seqDboList);
        service.deleteAll();
        assertThrows(IllegalArgumentException.class, () -> service.delete(databaseObject3));
    }

}