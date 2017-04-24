package com.github.tomschi.commons.api.dto.rest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @since 0.1.0
 * @author Tomschi
 */
public class RestDtoTest {

    private final TestRestDto restDto1 = new TestRestDto();
    private final TestRestDto restDto2 = new TestRestDto();

    private final TestIdentifiableRestDto1 idRestDto11 = new TestIdentifiableRestDto1();
    private final TestIdentifiableRestDto1 idRestDto12 = new TestIdentifiableRestDto1();

    private final TestIdentifiableRestDto2 idRestDto21 = new TestIdentifiableRestDto2();

    @Test
    public void testRestDtoEquals() {
        assertNotEquals(restDto1, restDto2);
    }

    @Test
    public void testRestDtoHashCode() {
        assertNotEquals(restDto1.hashCode(), restDto2.hashCode());
    }

    @Test
    public void testIdentifiableRestDtoEquals() {
        idRestDto11.setId(1L);
        idRestDto12.setId(2L);
        idRestDto21.setId(1L);

        assertTrue(idRestDto11.equals(idRestDto11));
        assertFalse(idRestDto11.equals(idRestDto12));
        assertFalse(idRestDto11.equals(null));

        idRestDto12.setId(1L);
        assertTrue(idRestDto11.equals(idRestDto12));
        assertFalse(idRestDto11.equals(idRestDto21));
    }

    @Test
    public void testIdentifiableRestDtoHashCode() {
        idRestDto11.setId(1L);
        idRestDto12.setId(2L);
        idRestDto21.setId(1L);

        assertEquals(idRestDto11.hashCode(), idRestDto11.hashCode());
        assertNotEquals(idRestDto11.hashCode(), idRestDto12.hashCode());
        assertNotEquals(idRestDto11.hashCode(), idRestDto21.hashCode());

        idRestDto12.setId(1L);
        assertEquals(idRestDto11.hashCode(), idRestDto12.hashCode());
    }

    @Test(expected = IllegalStateException.class)
    public void testIdentifiableRestDtoWithoutIdEquals() {
        idRestDto11.setId(null);
        idRestDto11.equals(idRestDto12);
    }

    @Test(expected = IllegalStateException.class)
    public void testIdentifiableRestDtoWithoutIdHashCode() {
        idRestDto11.setId(null);
        idRestDto11.hashCode();
    }

}
