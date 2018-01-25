package com.github.tomschi.commons.springdatajpa.dbo;

import com.github.tomschi.commons.data.test.dbo.jpa.BarJpaSequenceDbo;
import com.github.tomschi.commons.data.test.dbo.jpa.FooJpaSequenceDbo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tomschi
 */
class AbstractJpaSequenceDboTest {

    @Test
    void testEqualsHashCodeSuccess() {
        com.github.tomschi.commons.data.dbo.jpa.JpaSequenceDbo first = new BarJpaSequenceDbo(1L);
        com.github.tomschi.commons.data.dbo.jpa.JpaSequenceDbo second = new BarJpaSequenceDbo(1L);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    void testEqualsFails() {
        com.github.tomschi.commons.data.dbo.jpa.JpaSequenceDbo first = new BarJpaSequenceDbo(1L);
        com.github.tomschi.commons.data.dbo.jpa.JpaSequenceDbo second = new BarJpaSequenceDbo(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(null);
        second.setId(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(1L);
        second = new FooJpaSequenceDbo(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

}