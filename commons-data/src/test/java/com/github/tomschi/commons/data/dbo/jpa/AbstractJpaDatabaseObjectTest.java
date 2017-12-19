package com.github.tomschi.commons.data.dbo.jpa;

import com.github.tomschi.commons.data.dbo.jpa.testdbo.JpaDboOne;
import com.github.tomschi.commons.data.dbo.jpa.testdbo.JpaDboTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tomschi
 */
public class AbstractJpaDatabaseObjectTest {

    @Test
    public void testEqualsHashCodeSuccess() {
        JpaDboOne first = new JpaDboOne(1L);
        JpaDboOne second = new JpaDboOne(1L);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    public void testEqualsFails() {
        JpaDatabaseObject<Long> first = new JpaDboOne(1L);
        JpaDatabaseObject<Long> second = new JpaDboOne(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(null);
        second.setId(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(1L);
        second = new JpaDboTwo(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

}