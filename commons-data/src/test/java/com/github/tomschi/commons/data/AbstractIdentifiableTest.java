package com.github.tomschi.commons.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AbstractIdentifiableTest {

    @Test
    void testHashCode() {
        BarIdentifiable barIdentifiable = new BarIdentifiable(1L);
        FooIdentifiable fooIdentifiable = new FooIdentifiable(1L);

        int hash = barIdentifiable.getClass().getName().hashCode() * 13 + (Integer.valueOf(1).hashCode());
        assertEquals(hash, barIdentifiable.hashCode());

        assertNotEquals(barIdentifiable.hashCode(), fooIdentifiable.hashCode());
    }

    @Test
    void testEquals() {
        BarIdentifiable barIdentifiable = new BarIdentifiable(1L);
        FooIdentifiable fooIdentifiable = new FooIdentifiable(1L);

        assertEquals(barIdentifiable, barIdentifiable);
        assertNotEquals(barIdentifiable, fooIdentifiable);
    }
}