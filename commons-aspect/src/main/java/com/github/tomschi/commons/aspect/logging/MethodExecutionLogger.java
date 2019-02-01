/*-
 * #%L
 * commons-aspect
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
package com.github.tomschi.commons.aspect.logging;

import com.github.tomschi.commons.annotation.logging.LogExecution;
import com.github.tomschi.commons.slf4j.Slf4jUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * The aspect MethodExecutionLogger logs the execution time of methods. For this
 * purpose the target method must be annotated with {@link LogExecution}
 * annotation.
 *
 * <br>
 *
 * It is also possible to annotate the class with {@link LogExecution}.
 * Then all public methods of the class are logged.
 *
 * @author Tomschi
 * @since 0.1.1
 */
@Aspect
public class MethodExecutionLogger {

    private final static String logMessage = "Method {} needs {} to execute.";

    /**
     * Returns the {@link LogExecution} of the called method. When
     * called method hasn't a annotation the class annotation is returned.
     *
     * @param clazz The {@link Class} of the called method.
     * @param method The called {@link Method}.
     * @return The {@link LogExecution} annotation.
     */
    private LogExecution getAnnotation(Class<?> clazz, Method method) {
        LogExecution annotation = method.getAnnotation(LogExecution.class);
        if (annotation == null) {
            annotation = clazz.getAnnotation(LogExecution.class);
        }
        return annotation;
    }

    /**
     * Checks if the method execution time should be logged. This method
     * compares the {@link LogExecution#limit()} and the given execution time.
     *
     * <br>
     *
     * If {@link LogExecution#limit()} is less than the given execution time
     * the method returns <code>true</code>, else <code>false</code>.
     *
     * @param annotation A {@link LogExecution} annotation.
     * @param executionTimeMillis The execution time in millis.
     * @return <code>True</code>, if {@link LogExecution#limit()} is less than
     *         executionTimeMillis, else <code>false</code>
     */
    private boolean shouldLog(LogExecution annotation, long executionTimeMillis) {
        long limit = annotation.limit();
        TimeUnit limitTimeUnit = annotation.timeUnit();

        switch (limitTimeUnit) {
            case NANOSECONDS:
                return limit < TimeUnit.MILLISECONDS.toNanos(executionTimeMillis);
            case MICROSECONDS:
                return limit < TimeUnit.MILLISECONDS.toMicros(executionTimeMillis);
            case MILLISECONDS:
                return limit < executionTimeMillis;
            case SECONDS:
                return limit < TimeUnit.MILLISECONDS.toSeconds(executionTimeMillis);
            case MINUTES:
                return limit < TimeUnit.MILLISECONDS.toMinutes(executionTimeMillis);
            case HOURS:
                return limit < TimeUnit.MILLISECONDS.toHours(executionTimeMillis);
            case DAYS:
                return limit < TimeUnit.MILLISECONDS.toDays(executionTimeMillis);
            default:
                return false;
        }
    }

    /**
     * This method is marked as {@link Pointcut}. It checks, if the called
     * method is a public method.
     */
    @Pointcut("execution(public * *(..))")
    public void publicMethod() {}

    /**
     * This method is marked as {@link Pointcut}. It checks, if the class
     * of the called method is annotated with {@link LogExecution}.
     */
    @Pointcut("@within(com.github.tomschi.commons.annotation.logging.LogExecution)")
    public void annotatedBean() {}

    /**
     * This method is marked as {@link Pointcut}. It checks, if the called
     * method is annotated with {@link LogExecution}
     */
    @Pointcut("@annotation(com.github.tomschi.commons.annotation.logging.LogExecution)")
    public void annotatedMethod() {}

    /**
     * This method is called, when a method is annotated with {@link LogExecution} or
     * a class is annotated with {@link LogExecution} and the called method is public.
     *
     * <br>
     *
     * The method calculates the execution time of the called method. For this purpose
     * the {@link StopWatch} is used. It will be only logged, if the execution time is
     * greater than the {@link LogExecution#limit()} and the {@link Logger} is enabled
     * for the class. The message will be logged with the {@link Logger} of the class, whose
     * method is called.
     *
     * @param joinPoint The {@link ProceedingJoinPoint}.
     * @return The method result of the called method.
     * @throws Throwable If error occurs.
     */
    @Around("(publicMethod() && annotatedBean()) || annotatedMethod()")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
        Class<?> clazz = joinPoint.getTarget().getClass();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        LogExecution annotation = getAnnotation(clazz, method);
        Logger logger = LoggerFactory.getLogger(clazz);

        Object methodResult;

        if (!Slf4jUtils.isEnabled(logger, annotation.value())) {
            methodResult = joinPoint.proceed();
        } else {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            methodResult = joinPoint.proceed();
            stopWatch.stop();

            if (shouldLog(annotation, stopWatch.getTime())) {
                Slf4jUtils.log(logger, annotation.value(), logMessage, method.getName(), DurationFormatUtils.formatDurationHMS(stopWatch.getTime()));
            }
        }

        return methodResult;
    }

}
