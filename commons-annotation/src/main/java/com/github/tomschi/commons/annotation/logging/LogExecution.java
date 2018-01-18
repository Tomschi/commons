package com.github.tomschi.commons.annotation.logging;

import org.slf4j.event.Level;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * Enables logging execution time of a method. It is possible
 * to annotate classes and methods. When a class is annotated
 * every public method of the class will be logged over slf4j.
 *
 * <br>
 *
 * To enable this feature the MethodLogger aspect of the commons-aspect
 * library is needed.
 *
 * @author Tomschi
 * @since 0.1.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface LogExecution {

    /**
     * The Log {@link Level}, which should be used for logging.
     * Default is {@link Level#DEBUG}.
     *
     * @return The Log {@link Level}. Default is {@link Level#DEBUG}
     */
    Level value() default Level.DEBUG;

    /**
     * The time limit, when the execution should be logged.
     * When the execution time is greater than the limit,
     * the execution time is logged.
     *
     * <br>
     *
     * The default value is 0, so the execution time is
     * always greater than the limit.
     *
     * @return The limit, default is 0.
     */
    long limit() default 0;

    /**
     * The {@link TimeUnit} of the {@link LogExecution#limit()}.
     * Default is {@link TimeUnit#MILLISECONDS}.
     *
     * @return The {@link TimeUnit} for the {@link LogExecution#limit()}.
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

}
