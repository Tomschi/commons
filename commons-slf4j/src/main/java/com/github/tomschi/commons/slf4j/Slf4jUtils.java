/*-
 * #%L
 * commons-slf4j
 * %%
 * Copyright (C) 2018 - 2019 Tomschi
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.tomschi.commons.slf4j;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/**
 * The utility class {@link Slf4jUtils} offers static methods for Slf4j.
 * It enables the possibility to call log methods with {@link Logger} and
 * log {@link Level} as parameters.
 *
 * @author Tomschi
 * @since 0.1.1
 */
public final class Slf4jUtils {

    private Slf4jUtils() {
    }

    private static void logHelper(Logger logger, Level level, String string, Object... arguments) {
        switch (level) {
            case TRACE:
                logger.trace(string, arguments);
                break;
            case DEBUG:
                logger.debug(string, arguments);
                break;
            case INFO:
                logger.info(string, arguments);
                break;
            case WARN:
                logger.warn(string, arguments);
                break;
            case ERROR:
                logger.error(string, arguments);
                break;
        }
    }

    private static void logHelper(Logger logger, Level level, Marker marker, String format, Object... arguments) {
        switch (level) {
            case TRACE:
                logger.trace(marker, format, arguments);
                break;
            case DEBUG:
                logger.debug(marker, format, arguments);
                break;
            case INFO:
                logger.info(marker, format, arguments);
                break;
            case WARN:
                logger.warn(marker, format, arguments);
                break;
            case ERROR:
                logger.error(marker, format, arguments);
                break;
        }
    }

    /**
     * Logs to the given {@link Logger} with the given {@link Level}.
     *
     * @param logger The {@link Logger} for the log.
     * @param level The log {@link Level}.
     * @param msg The message to log.
     */
    public static void log(Logger logger, Level level, String msg) {
        logHelper(logger, level, msg);
    }

    /**
     * Logs to the given {@link Logger} with the given {@link Level}.
     *
     * @param logger The {@link Logger} for the log.
     * @param level The log {@link Level}.
     * @param msg The message to log.
     * @param t The {@link Throwable} to log.
     */
    public static void log(Logger logger, Level level, String msg, Throwable t) {
        logHelper(logger, level, msg, t);
    }

    /**
     * Logs to the given {@link Logger} with the given {@link Level}.
     *
     * @param logger The {@link Logger} for the log.
     * @param level The log {@link Level}.
     * @param format The message {@link String} to log in specific format.
     * @param arguments The arguments for the given format {@link String}.
     */
    public static void log(Logger logger, Level level, String format, Object... arguments) {
        logHelper(logger, level, format, arguments);
    }

    /**
     * Logs to the given {@link Logger} with the given {@link Level} and {@link Marker}.
     *
     * @param logger The {@link Logger} for the log.
     * @param level The log {@link Level}.
     * @param marker The {@link Marker}.
     * @param msg The message to log.
     */
    public static void log(Logger logger, Level level, Marker marker, String msg) {
        logHelper(logger, level, marker, msg);
    }

    /**
     * Logs to the given {@link Logger} with the given {@link Level} and {@link Marker}.
     *
     * @param logger The {@link Logger} for the log.
     * @param level The log {@link Level}.
     * @param marker The {@link Marker}.
     * @param msg The message to log.
     * @param t The {@link Throwable} to log.
     */
    public static void log(Logger logger, Level level, Marker marker, String msg, Throwable t) {
        logHelper(logger, level, marker, msg, t);
    }

    /**
     * Logs to the given {@link Logger} with the given {@link Level} and {@link Marker}.
     *
     * @param logger The {@link Logger} for the log.
     * @param level The log {@link Level}.
     * @param marker The {@link Marker}.
     * @param format The message {@link String} to log in specific format.
     * @param arguments The arguments for the given format {@link String}.
     */
    public static void log(Logger logger, Level level, Marker marker, String format, Object... arguments) {
        logHelper(logger, level, marker, format, arguments);
    }

    /**
     * Checks if the given {@link Level} is enabled for the given
     * {@link Logger}.
     *
     * @param logger The {@link Logger} to check.
     * @param level The {@link Level}, which should be checked for the {@link Logger}.
     * @return True, if the {@link Level} is enabled for the {@link Logger}, else false.
     */
    public static boolean isEnabled(Logger logger, Level level) {
        switch (level) {
            case TRACE:
                return logger.isTraceEnabled();
            case DEBUG:
                return logger.isDebugEnabled();
            case INFO:
                return logger.isInfoEnabled();
            case WARN:
                return logger.isWarnEnabled();
            case ERROR:
                return logger.isErrorEnabled();
            default:
                throw new IllegalArgumentException("The given log level is not supported.");
        }
    }

    /**
     * Checks if the given {@link Level} is enabled for the given
     * {@link Logger} and {@link Marker}.
     *
     * @param logger The {@link Logger} to check.
     * @param level The {@link Level}, which should be checked for the {@link Logger} and {@link Marker}.
     * @param marker The {@link Marker} to check.
     * @return True, if the {@link Level} is enabled for the {@link Logger} and the {@link Marker}, else false.
     */
    public static boolean isEnabled(Logger logger, Level level, Marker marker) {
        switch (level) {
            case TRACE:
                return logger.isTraceEnabled(marker);
            case DEBUG:
                return logger.isDebugEnabled(marker);
            case INFO:
                return logger.isInfoEnabled(marker);
            case WARN:
                return logger.isWarnEnabled(marker);
            case ERROR:
                return logger.isErrorEnabled(marker);
            default:
                throw new IllegalArgumentException("The given log level is not supported.");
        }
    }

}
