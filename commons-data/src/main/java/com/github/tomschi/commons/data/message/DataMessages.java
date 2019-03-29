/*-
 * #%L
 * commons-data
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
package com.github.tomschi.commons.data.message;

import com.github.tomschi.commons.message.MessageGenerator;

import javax.annotation.Nonnull;

public final class DataMessages {

    private static final String PARAM_NOT_PERSIST_MSG = "The parameter {0} must be persisted first.";
    private static final String PARAM_PRODUCE_CYCLE_MSG = "The given parameters produces a cycle.";

    private DataMessages() {
    }

    @Nonnull
    public static String paramNotPersistMsg(@Nonnull String parameterName) {
        return MessageGenerator.getMessage(PARAM_NOT_PERSIST_MSG, parameterName);
    }

    @Nonnull
    public static String paramProduceCycleMsg() {
        return PARAM_PRODUCE_CYCLE_MSG;
    }

}
