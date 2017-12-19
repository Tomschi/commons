package com.github.tomschi.commons.data.dto.rest;

import com.github.tomschi.commons.data.dto.rest.testdto.RESTIdentifiableDtoOne;
import com.github.tomschi.commons.data.dto.rest.testdto.RESTIdentifiableDtoTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tomschi
 */
public class AbstractRESTIdentifiableDtoTest {

    @Test
    public void testEqualsHashCodeSuccess() {
        RESTIdentifiableDto<Long> first = new RESTIdentifiableDtoOne(1L);
        RESTIdentifiableDto<Long> second = new RESTIdentifiableDtoOne(1L);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    public void testEqualsFails() {
        RESTIdentifiableDto<Long> first = new RESTIdentifiableDtoOne(1L);
        RESTIdentifiableDto<Long> second = new RESTIdentifiableDtoOne(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(null);
        second.setId(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(1L);
        second = new RESTIdentifiableDtoTwo(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

}