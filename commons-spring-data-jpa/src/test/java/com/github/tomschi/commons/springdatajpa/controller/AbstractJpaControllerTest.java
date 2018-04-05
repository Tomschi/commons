package com.github.tomschi.commons.springdatajpa.controller;

import com.github.tomschi.commons.springdatajpa.dbo.FooJpaSequenceDbo;
import com.github.tomschi.commons.springdatajpa.service.FooJpaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbstractJpaControllerTest {

    @Mock private FooJpaService service;
    @Mock private Page<FooJpaSequenceDbo> page;
    @Mock private Pageable pageable;
    @Mock private Sort sort;
    
    private FooJpaController controller;
    private FooJpaSequenceDbo databaseObject1 = new FooJpaSequenceDbo(1L);
    private FooJpaSequenceDbo databaseObject2 = new FooJpaSequenceDbo(2L);
    private List<FooJpaSequenceDbo> dboList = Arrays.asList(databaseObject1, databaseObject2);

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);

        controller = new FooJpaController(service);

        when(page.getContent()).thenReturn(dboList);

        when(service.newInstance()).thenReturn(new FooJpaSequenceDbo());

        when(service.findAll()).thenReturn(dboList);
        when(service.findAll(any(Sort.class))).thenReturn(dboList);
        when(service.findAllById(anyList())).thenReturn(dboList);
        when(service.findAll(any(Pageable.class))).thenReturn(page);

        when(service.save(databaseObject1)).thenReturn(databaseObject1);
        when(service.saveAll(dboList)).then(returnsFirstArg());

        when(service.findById(anyLong())).thenReturn(Optional.ofNullable(databaseObject1));

        when(service.existsById(anyLong())).thenReturn(false);
        when(service.existsById(1L)).thenReturn(true);
        when(service.existsById(2L)).thenReturn(true);

        when(service.count()).thenReturn(Integer.valueOf(dboList.size()).longValue());
    }

    @Test
    void testNewInstance() {
        assertNotNull(controller.newInstance());
    }

    @Test
    void testFindAll() {
        assertEquals(2, controller.findAll().size());
        assertEquals(2, controller.findAll(sort).size());
        assertEquals(2, controller.findAllById(new ArrayList<>(0)).size());
        assertEquals(2, controller.findAll(pageable).getContent().size());
    }

    @Test
    void testSave() {
        assertEquals(databaseObject1.getId(), controller.save(databaseObject1).getId());
        assertEquals(2, controller.saveAll(dboList).size());
    }

    @Test
    void testFindOne() {
        assertEquals(databaseObject1, controller.findById(1L).orElse(databaseObject2));
    }

    @Test
    void testExists() {
        assertTrue(controller.existsById(1L));
        assertTrue(controller.existsById(2L));
        assertFalse(controller.existsById(100L));
    }

    @Test
    void testCount() {
        assertEquals(Integer.valueOf(dboList.size()).longValue(), controller.count());
    }

    @Test
    void testDelete() {
        controller.deleteById(2L);
        controller.delete(databaseObject1);
        controller.deleteAll(dboList);
        controller.deleteAll();
        assertTrue(true);
    }

}