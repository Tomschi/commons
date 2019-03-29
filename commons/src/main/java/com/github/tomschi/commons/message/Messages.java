/*-
 * #%L
 * commons
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
package com.github.tomschi.commons.message;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Messages {

    private static final String PARAM_NOT_NULL_MSG = "The given method parameter {0} must not be null.";
    private static final String PARAM_TYPE_NOT_SUPPORTED_MSG = "The type {0} of parameter {1} is not supported. Only types of {2} are allowed.";

    @Nonnull
    public static String paramNotNullMsg(@Nonnull String parameterName) {
        return MessageGenerator.getMessage(PARAM_NOT_NULL_MSG, parameterName);
    }

    @Nonnull
    public static String paramTypeNotSupportedMsg(@Nonnull Class<?> expectedClass, @Nullable Object obj, @Nonnull String parameterName) {
        if (obj != null) {
            String expectedClassName = expectedClass.getSimpleName();
            String objClassName = obj.getClass().getSimpleName();
            return MessageGenerator.getMessage(PARAM_TYPE_NOT_SUPPORTED_MSG, objClassName, parameterName, expectedClassName);
        } else {
            return paramNotNullMsg(parameterName);
        }
    }

}
