package com.github.tomschi.commons.api.dbo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @since 0.1.0
 * @author Tomschi
 */
public class DatabaseObjectTest {

    private final TestDatabaseObject databaseObject1 = new TestDatabaseObject();
    private final TestDatabaseObject databaseObject2 = new TestDatabaseObject();

    private final TestBusinessKeyDbo businessKeyDbo1 = new TestBusinessKeyDbo();
    private final TestBusinessKeyDbo businessKeyDbo2 = new TestBusinessKeyDbo();

    private final TestSurrogateKeyDbo surrogateKeyDbo1 = new TestSurrogateKeyDbo();
    private final TestSurrogateKeyDbo surrogateKeyDbo2 = new TestSurrogateKeyDbo();

    @Test
    public void testDatabaseObjectEquals() {
        assertTrue(databaseObject1.equals(databaseObject1));
        assertFalse(databaseObject1.equals(databaseObject2));
        assertFalse(databaseObject1.equals(businessKeyDbo1));
        assertFalse(databaseObject1.equals(surrogateKeyDbo1));
    }

    @Test
    public void testDatabaseObjectHashCode() {
        assertEquals(databaseObject1.hashCode(), databaseObject1.hashCode());
        assertNotEquals(databaseObject1.hashCode(), databaseObject2.hashCode());

        businessKeyDbo1.setBusinessKey(1L);
        surrogateKeyDbo1.setSurrogateKey(null);
        assertNotEquals(databaseObject1.hashCode(), businessKeyDbo1.hashCode());
        assertNotEquals(databaseObject1.hashCode(), surrogateKeyDbo2.hashCode());
    }

    @Test
    public void testBusinessKeyObjectPrimaryKey() {
        businessKeyDbo1.setBusinessKey(1L);
        assertEquals(businessKeyDbo1.getPrimaryKey(), businessKeyDbo1.getBusinessKey());

        businessKeyDbo1.setPrimaryKey(2L);
        assertEquals(businessKeyDbo1.getBusinessKey(), businessKeyDbo1.getPrimaryKey());
    }

    @Test
    public void testBusinessKeyDboEquals() {
        businessKeyDbo1.setBusinessKey(1L);
        businessKeyDbo2.setBusinessKey(2L);
        surrogateKeyDbo1.setSurrogateKey(1L);
        surrogateKeyDbo2.setSurrogateKey(2L);

        assertTrue(businessKeyDbo1.equals(businessKeyDbo1));
        assertTrue(businessKeyDbo2.equals(businessKeyDbo2));
        assertFalse(businessKeyDbo1.equals(businessKeyDbo2));
        assertFalse(businessKeyDbo2.equals(businessKeyDbo1));
        assertFalse(businessKeyDbo1.equals(null));

        businessKeyDbo2.setBusinessKey(1L);
        assertTrue(businessKeyDbo1.equals(businessKeyDbo2));
        assertTrue(businessKeyDbo2.equals(businessKeyDbo1));

        assertFalse(businessKeyDbo1.equals(databaseObject1));
        assertFalse(businessKeyDbo1.equals(surrogateKeyDbo1));
    }

    @Test
    public void testBusinessKeyDboHashCode() {
        businessKeyDbo1.setBusinessKey(1L);
        businessKeyDbo2.setBusinessKey(2L);
        assertNotEquals(businessKeyDbo1.hashCode(), businessKeyDbo2.hashCode());

        businessKeyDbo2.setBusinessKey(1L);
        assertEquals(businessKeyDbo1.hashCode(), businessKeyDbo2.hashCode());
    }

    @Test(expected = IllegalStateException.class)
    public void testBusinessKeyDboWithoutKeyEquals() {
        businessKeyDbo1.setBusinessKey(null);
        businessKeyDbo1.equals(businessKeyDbo2);
    }

    @Test(expected = IllegalStateException.class)
    public void testBusinessKeyDboWithoutKeyHashCode() {
        businessKeyDbo1.setBusinessKey(null);
        businessKeyDbo1.hashCode();
    }

    @Test
    public void testSurrogateKeyDboPrimaryKey() {
        surrogateKeyDbo1.setSurrogateKey(1L);
        assertEquals(surrogateKeyDbo1.getPrimaryKey(), surrogateKeyDbo1.getSurrogateKey());

        surrogateKeyDbo1.setPrimaryKey(2L);
        assertEquals(surrogateKeyDbo1.getSurrogateKey(), surrogateKeyDbo1.getPrimaryKey());
    }

    @Test
    public void testSurrogateKeyDboEquals() {
        businessKeyDbo1.setBusinessKey(1L);
        businessKeyDbo2.setBusinessKey(2L);
        surrogateKeyDbo1.setSurrogateKey(1L);
        surrogateKeyDbo2.setSurrogateKey(2L);

        assertTrue(surrogateKeyDbo1.equals(surrogateKeyDbo1));
        assertTrue(surrogateKeyDbo2.equals(surrogateKeyDbo2));
        assertFalse(surrogateKeyDbo1.equals(surrogateKeyDbo2));
        assertFalse(surrogateKeyDbo2.equals(surrogateKeyDbo1));
        assertFalse(surrogateKeyDbo1.equals(null));

        surrogateKeyDbo2.setSurrogateKey(1L);
        assertTrue(surrogateKeyDbo1.equals(surrogateKeyDbo2));
        assertTrue(surrogateKeyDbo2.equals(surrogateKeyDbo1));

        assertFalse(surrogateKeyDbo1.equals(databaseObject1));
        assertFalse(surrogateKeyDbo1.equals(businessKeyDbo1));
    }

    @Test
    public void testSurrogateKeyDboHashCode() {
        surrogateKeyDbo1.setSurrogateKey(1L);
        surrogateKeyDbo2.setSurrogateKey(2L);
        assertNotEquals(surrogateKeyDbo1.hashCode(), surrogateKeyDbo2.hashCode());

        surrogateKeyDbo2.setSurrogateKey(1L);
        assertEquals(surrogateKeyDbo1.hashCode(), surrogateKeyDbo2.hashCode());
    }

}
