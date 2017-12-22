package com.github.tomschi.commons.slf4j;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.event.Level;
import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link Slf4jUtils}.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public class Slf4jUtilsTest {

    private final static TestLogger log = TestLoggerFactory.getTestLogger(Slf4jUtilsTest.class);

    private final static String LOG_MSG = "Simple log message";
    private final static String ARG_1 = "Argument 1";
    private final static String ARG_2 = "Argument 2";

    private final static IllegalArgumentException EXCEPTION = new IllegalArgumentException("Simple log Exception");
    private final static Marker MARKER = MarkerFactory.getMarker("Test Marker");

    @AfterEach
    void tearDown() {
        log.clear();
    }

    private uk.org.lidalia.slf4jext.Level toLevel(Level level) {
        switch (level) {
            case TRACE: return uk.org.lidalia.slf4jext.Level.TRACE;
            case DEBUG: return uk.org.lidalia.slf4jext.Level.DEBUG;
            case INFO: return uk.org.lidalia.slf4jext.Level.INFO;
            case WARN: return uk.org.lidalia.slf4jext.Level.WARN;
            case ERROR:return uk.org.lidalia.slf4jext.Level.ERROR;
            default: return null;
        }
    }

    private LoggingEvent assertSizeOneAndGetLoggingEvent(List<LoggingEvent> loggingEvents) {
        assertEquals(1, loggingEvents.size());
        return loggingEvents.iterator().next();
    }

    private void assertLevelAndMessage(Level level, LoggingEvent event) {
        assertEquals(toLevel(level), event.getLevel());
        assertEquals(LOG_MSG, event.getMessage());
    }

    private void assertLog(Level level) {
        assertLog(level, null);
    }

    private void assertLog(Level level, Marker marker) {
        if (marker == null) {
            Slf4jUtils.log(log, level, LOG_MSG);
        } else {
            Slf4jUtils.log(log, level, marker, LOG_MSG);
        }
        LoggingEvent event = assertSizeOneAndGetLoggingEvent(log.getLoggingEvents());
        assertLevelAndMessage(level, event);

        if (marker != null) {
            assertEquals(marker, (event.getMarker().isPresent()) ? event.getMarker().get() : null);
        }

        log.clear();
    }

    @Test
    void testLog() {
        assertLog(Level.TRACE);
        assertLog(Level.DEBUG);
        assertLog(Level.INFO);
        assertLog(Level.WARN);
        assertLog(Level.ERROR);
    }

    @Test
    void testMarkerLog() {
        assertLog(Level.TRACE, MARKER);
        assertLog(Level.DEBUG, MARKER);
        assertLog(Level.INFO, MARKER);
        assertLog(Level.WARN, MARKER);
        assertLog(Level.ERROR, MARKER);
    }

    private void assertArgLog(Level level) {
        assertArgLog(level, null);
    }

    private void assertArgLog(Level level, Marker marker) {
        if (marker == null) {
            Slf4jUtils.log(log, level, LOG_MSG, ARG_1, ARG_2);
        } else {
            Slf4jUtils.log(log, level, marker, LOG_MSG, ARG_1, ARG_2);
        }

        LoggingEvent event = assertSizeOneAndGetLoggingEvent(log.getLoggingEvents());
        assertLevelAndMessage(level, event);

        Iterator<Object> it = event.getArguments().iterator();
        assertEquals(ARG_1, it.next());
        assertEquals(ARG_2, it.next());

        if (marker != null) {
            assertEquals(marker, (event.getMarker().isPresent()) ? event.getMarker().get() : null);
        }

        log.clear();
    }

    @Test
    void testArgLog() {
        assertArgLog(Level.TRACE);
        assertArgLog(Level.DEBUG);
        assertArgLog(Level.INFO);
        assertArgLog(Level.WARN);
        assertArgLog(Level.ERROR);
    }

    @Test
    void testMarkerArgLog() {
        assertArgLog(Level.TRACE, MARKER);
        assertArgLog(Level.DEBUG, MARKER);
        assertArgLog(Level.INFO, MARKER);
        assertArgLog(Level.WARN, MARKER);
        assertArgLog(Level.ERROR, MARKER);
    }

    private void assertExceptionLog(Level level) {
        assertExceptionLog(level, null);
    }

    private void assertExceptionLog(Level level, Marker marker) {
        if (marker == null) {
            Slf4jUtils.log(log, level, LOG_MSG, EXCEPTION);
        } else {
            Slf4jUtils.log(log, level, marker, LOG_MSG, EXCEPTION);
        }
        LoggingEvent event = assertSizeOneAndGetLoggingEvent(log.getLoggingEvents());
        assertLevelAndMessage(level, event);
        assertEquals(EXCEPTION, (event.getThrowable().isPresent()) ? event.getThrowable().get() : null);

        if (marker != null) {
            assertEquals(marker, (event.getMarker().isPresent()) ? event.getMarker().get() : null);
        }

        log.clear();
    }

    @Test
    void testExceptionLog() {
        assertExceptionLog(Level.TRACE);
        assertExceptionLog(Level.DEBUG);
        assertExceptionLog(Level.INFO);
        assertExceptionLog(Level.WARN);
        assertExceptionLog(Level.ERROR);
    }

    @Test
    void testMarkerExceptionLog() {
        assertExceptionLog(Level.TRACE, MARKER);
        assertExceptionLog(Level.DEBUG, MARKER);
        assertExceptionLog(Level.INFO, MARKER);
        assertExceptionLog(Level.WARN, MARKER);
        assertExceptionLog(Level.ERROR, MARKER);
    }

    @Test
    void testIsLoggerEnabled() {
        assertTrue(Slf4jUtils.isEnabled(log, Level.TRACE));
        assertTrue(Slf4jUtils.isEnabled(log, Level.TRACE, MARKER));
        assertTrue(Slf4jUtils.isEnabled(log, Level.DEBUG));
        assertTrue(Slf4jUtils.isEnabled(log, Level.DEBUG, MARKER));
        assertTrue(Slf4jUtils.isEnabled(log, Level.INFO));
        assertTrue(Slf4jUtils.isEnabled(log, Level.INFO, MARKER));
        assertTrue(Slf4jUtils.isEnabled(log, Level.WARN));
        assertTrue(Slf4jUtils.isEnabled(log, Level.WARN, MARKER));
        assertTrue(Slf4jUtils.isEnabled(log, Level.ERROR));
        assertTrue(Slf4jUtils.isEnabled(log, Level.ERROR, MARKER));
    }

}
