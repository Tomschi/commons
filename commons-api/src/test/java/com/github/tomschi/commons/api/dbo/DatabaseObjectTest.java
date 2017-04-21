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

    private final TestBusinessKeyDbo1 businessKeyDbo11 = new TestBusinessKeyDbo1();
    private final TestBusinessKeyDbo1 businessKeyDbo12 = new TestBusinessKeyDbo1();

    private final TestSurrogateKeyDbo1 surrogateKeyDbo11 = new TestSurrogateKeyDbo1();
    private final TestSurrogateKeyDbo1 surrogateKeyDbo12 = new TestSurrogateKeyDbo1();

    @Test
    public void testDatabaseObjectEquals() {
        assertTrue(databaseObject1.equals(databaseObject1));
        assertFalse(databaseObject1.equals(databaseObject2));
        assertFalse(databaseObject1.equals(businessKeyDbo11));
        assertFalse(databaseObject1.equals(surrogateKeyDbo11));
    }

    @Test
    public void testDatabaseObjectHashCode() {
        assertEquals(databaseObject1.hashCode(), databaseObject1.hashCode());
        assertNotEquals(databaseObject1.hashCode(), databaseObject2.hashCode());

        businessKeyDbo11.setBusinessKey(1L);
        surrogateKeyDbo11.setSurrogateKey(null);
        assertNotEquals(databaseObject1.hashCode(), businessKeyDbo11.hashCode());
        assertNotEquals(databaseObject1.hashCode(), surrogateKeyDbo12.hashCode());
    }

    @Test
    public void testBusinessKeyObjectPrimaryKey() {
        businessKeyDbo11.setBusinessKey(1L);
        assertEquals(businessKeyDbo11.getPrimaryKey(), businessKeyDbo11.getBusinessKey());

        businessKeyDbo11.setPrimaryKey(2L);
        assertEquals(businessKeyDbo11.getBusinessKey(), businessKeyDbo11.getPrimaryKey());
    }

    @Test
    public void testBusinessKeyDboEquals() {
        businessKeyDbo11.setBusinessKey(1L);
        businessKeyDbo12.setBusinessKey(2L);
        surrogateKeyDbo11.setSurrogateKey(1L);
        surrogateKeyDbo12.setSurrogateKey(2L);

        assertTrue(businessKeyDbo11.equals(businessKeyDbo11));
        assertTrue(businessKeyDbo12.equals(businessKeyDbo12));
        assertFalse(businessKeyDbo11.equals(businessKeyDbo12));
        assertFalse(businessKeyDbo12.equals(businessKeyDbo11));
        assertFalse(businessKeyDbo11.equals(null));

        businessKeyDbo12.setBusinessKey(1L);
        assertTrue(businessKeyDbo11.equals(businessKeyDbo12));
        assertTrue(businessKeyDbo12.equals(businessKeyDbo11));

        assertFalse(businessKeyDbo11.equals(databaseObject1));
        assertFalse(businessKeyDbo11.equals(surrogateKeyDbo11));
    }

    @Test
    public void testBusinessKeyDboHashCode() {
        businessKeyDbo11.setBusinessKey(1L);
        businessKeyDbo12.setBusinessKey(2L);
        assertNotEquals(businessKeyDbo11.hashCode(), businessKeyDbo12.hashCode());

        businessKeyDbo12.setBusinessKey(1L);
        assertEquals(businessKeyDbo11.hashCode(), businessKeyDbo12.hashCode());
    }

    @Test(expected = IllegalStateException.class)
    public void testBusinessKeyDboWithoutKeyEquals() {
        businessKeyDbo11.setBusinessKey(null);
        businessKeyDbo11.equals(businessKeyDbo12);
    }

    @Test(expected = IllegalStateException.class)
    public void testBusinessKeyDboWithoutKeyHashCode() {
        businessKeyDbo11.setBusinessKey(null);
        businessKeyDbo11.hashCode();
    }

    @Test
    public void testSurrogateKeyDboPrimaryKey() {
        surrogateKeyDbo11.setSurrogateKey(1L);
        assertEquals(surrogateKeyDbo11.getPrimaryKey(), surrogateKeyDbo11.getSurrogateKey());

        surrogateKeyDbo11.setPrimaryKey(2L);
        assertEquals(surrogateKeyDbo11.getSurrogateKey(), surrogateKeyDbo11.getPrimaryKey());
    }

    @Test
    public void testSurrogateKeyDboEquals() {
        businessKeyDbo11.setBusinessKey(1L);
        businessKeyDbo12.setBusinessKey(2L);
        surrogateKeyDbo11.setSurrogateKey(1L);
        surrogateKeyDbo12.setSurrogateKey(2L);

        assertTrue(surrogateKeyDbo11.equals(surrogateKeyDbo11));
        assertTrue(surrogateKeyDbo12.equals(surrogateKeyDbo12));
        assertFalse(surrogateKeyDbo11.equals(surrogateKeyDbo12));
        assertFalse(surrogateKeyDbo12.equals(surrogateKeyDbo11));
        assertFalse(surrogateKeyDbo11.equals(null));

        surrogateKeyDbo12.setSurrogateKey(1L);
        assertTrue(surrogateKeyDbo11.equals(surrogateKeyDbo12));
        assertTrue(surrogateKeyDbo12.equals(surrogateKeyDbo11));

        assertFalse(surrogateKeyDbo11.equals(databaseObject1));
        assertFalse(surrogateKeyDbo11.equals(businessKeyDbo11));
    }

    @Test
    public void testSurrogateKeyDboHashCode() {
        surrogateKeyDbo11.setSurrogateKey(1L);
        surrogateKeyDbo12.setSurrogateKey(2L);
        assertNotEquals(surrogateKeyDbo11.hashCode(), surrogateKeyDbo12.hashCode());

        surrogateKeyDbo12.setSurrogateKey(1L);
        assertEquals(surrogateKeyDbo11.hashCode(), surrogateKeyDbo12.hashCode());
    }

}
