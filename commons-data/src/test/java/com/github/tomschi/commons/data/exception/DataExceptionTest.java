package com.github.tomschi.commons.data.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DataExceptionTest {

    @Test
    void testConstructors() {
        NoSuchDataException exception = new NoSuchDataException();
        new NoSuchDataException("Test");
        new NoSuchDataException(exception);
        new NoSuchDataException("Test", exception);
        assertTrue(true);
    }

}