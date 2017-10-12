package com.github.tomschi.commons.data.dbo.sql;

import com.github.tomschi.commons.data.dbo.sql.testdbo.SQLSequenceDboOne;
import com.github.tomschi.commons.data.dbo.sql.testdbo.SQLSequenceDboTwo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Tomschi
 */
public class AbstractSQLSequenceDboTest {

    @Test
    public void testEqualsHashCodeSuccess() {
        SQLSequenceDbo first = new SQLSequenceDboOne(1L);
        SQLSequenceDbo second = new SQLSequenceDboOne(1L);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    public void testEqualsFails() {
        SQLSequenceDbo first = new SQLSequenceDboOne(1L);
        SQLSequenceDbo second = new SQLSequenceDboOne(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(null);
        second.setId(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(1L);
        second = new SQLSequenceDboTwo(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

}