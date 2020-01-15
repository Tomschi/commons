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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataMessagesTest {

    private static final String PARAM_ALREADY_EXISTS_MSG = "The parameter test with id 1 already exists.";
    private static final String PARAM_NOT_PERSIST_MSG = "The parameter test must be persisted first.";
    private static final String PARAM_PRODUCE_CYCLE_MSG = "The given parameters produces a cycle.";

    @Test
    void testParamAlreadyExistsMsg() {
        assertEquals(PARAM_ALREADY_EXISTS_MSG, DataMessages.paramAlreadyExistsMsg("test", String.valueOf(1)));
    }

    @Test
    void testParamNotPersistMsg() {
        assertEquals(PARAM_NOT_PERSIST_MSG, DataMessages.paramNotPersistMsg("test"));
    }

    @Test
    void paramProduceCycleMsg() {
        assertEquals(PARAM_PRODUCE_CYCLE_MSG, DataMessages.paramProduceCycleMsg());
    }

}
