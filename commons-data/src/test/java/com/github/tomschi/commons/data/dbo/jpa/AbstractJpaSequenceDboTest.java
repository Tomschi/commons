package com.github.tomschi.commons.data.dbo.jpa;

import com.github.tomschi.commons.data.dbo.jpa.testdbo.JpaSequenceDboOne;
import com.github.tomschi.commons.data.dbo.jpa.testdbo.JpaSequenceDboTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tomschi
 */
public class AbstractJpaSequenceDboTest {

    @Test
    public void testEqualsHashCodeSuccess() {
        JpaSequenceDbo first = new JpaSequenceDboOne(1L);
        JpaSequenceDbo second = new JpaSequenceDboOne(1L);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    public void testEqualsFails() {
        JpaSequenceDbo first = new JpaSequenceDboOne(1L);
        JpaSequenceDbo second = new JpaSequenceDboOne(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(null);
        second.setId(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(1L);
        second = new JpaSequenceDboTwo(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

}