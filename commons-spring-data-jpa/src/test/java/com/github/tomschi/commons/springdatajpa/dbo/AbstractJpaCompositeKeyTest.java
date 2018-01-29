package com.github.tomschi.commons.springdatajpa.dbo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbstractJpaCompositeKeyTest {

    private FooJpaCompositeKey foo1;
    private FooJpaCompositeKey foo2;
    private BarJpaCompositeKey bar1;
    private BarJpaCompositeKey bar2;

    @BeforeAll
    void init() {
        foo1 = new FooJpaCompositeKey(1L, 2L);
        foo2 = new FooJpaCompositeKey(1L, 2L);
        bar1 = new BarJpaCompositeKey(1L, 2L);
        bar2 = new BarJpaCompositeKey(1L, 2L);
    }

    @Test
    void testEquals() {
        assertTrue(foo1.equals(foo1));
        assertTrue(foo1.equals(foo2));

        assertTrue(bar1.equals(bar1));
        assertTrue(bar1.equals(bar2));

        assertFalse(foo1.equals(bar1));
        assertFalse(foo2.equals(bar2));
    }

    @Test
    void testHashCode() {
        assertEquals(foo1.hashCode(), foo1.hashCode());
        assertEquals(foo1.hashCode(), foo2.hashCode());

        assertNotEquals(foo1.hashCode(), bar1.hashCode());
    }

}