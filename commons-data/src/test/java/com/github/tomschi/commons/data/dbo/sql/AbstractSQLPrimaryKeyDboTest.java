package com.github.tomschi.commons.data.dbo.sql;

import com.github.tomschi.commons.data.dbo.sql.testdbo.SQLPrimaryKeyDboOne;
import com.github.tomschi.commons.data.dbo.sql.testdbo.SQLPrimaryKeyDboTwo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Tomschi
 */
public class AbstractSQLPrimaryKeyDboTest {

    @Test
    public void testEqualsHashCodeSuccess() {
        SQLPrimaryKeyDboOne first = new SQLPrimaryKeyDboOne(1L);
        SQLPrimaryKeyDboOne second = new SQLPrimaryKeyDboOne(1L);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    public void testEqualsFails() {
        SQLPrimaryKeyDbo<Long> first = new SQLPrimaryKeyDboOne(1L);
        SQLPrimaryKeyDbo<Long> second = new SQLPrimaryKeyDboOne(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setPrimaryKey(null);
        second.setPrimaryKey(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setPrimaryKey(1L);
        second = new SQLPrimaryKeyDboTwo(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

}