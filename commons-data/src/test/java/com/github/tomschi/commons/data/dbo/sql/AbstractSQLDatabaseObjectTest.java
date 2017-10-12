package com.github.tomschi.commons.data.dbo.sql;

import com.github.tomschi.commons.data.dbo.sql.testdbo.SQLDboOne;
import com.github.tomschi.commons.data.dbo.sql.testdbo.SQLDboTwo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Tomschi
 */
public class AbstractSQLDatabaseObjectTest {

    @Test
    public void testEqualsHashCodeSuccess() {
        SQLDboOne first = new SQLDboOne(1L);
        SQLDboOne second = new SQLDboOne(1L);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    public void testEqualsFails() {
        SQLDatabaseObject<Long> first = new SQLDboOne(1L);
        SQLDatabaseObject<Long> second = new SQLDboOne(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(null);
        second.setId(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(1L);
        second = new SQLDboTwo(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

}