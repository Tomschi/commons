package com.github.tomschi.commons.data.dto.rest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tomschi
 */
class AbstractRESTIdentifiableDtoTest {

    @Test
    void testEqualsHashCodeSuccess() {
        RESTIdentifiableDto<Long> first = new BarRESTIdentifiableDto(1L);
        RESTIdentifiableDto<Long> second = new BarRESTIdentifiableDto(1L);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    void testEqualsFails() {
        RESTIdentifiableDto<Long> first = new BarRESTIdentifiableDto(1L);
        RESTIdentifiableDto<Long> second = new BarRESTIdentifiableDto(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(null);
        second.setId(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(1L);
        second = new FooRESTIdentifiableDto(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

}