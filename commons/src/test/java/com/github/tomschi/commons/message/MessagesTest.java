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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessagesTest {

    private static final String PARAM_NOT_NULL_MSG = "The given method parameter test must not be null.";
    private static final String PARAM_NOT_NUMERIC_MSG = "The given method parameter test must be numeric.";
    private static final String PARAM_TYPE_NOT_SUPPORTED_MSG = "The type String of parameter test is not supported. Only types of Number are allowed.";

    @Test
    void testParamNotNullMsg() {
        assertEquals(PARAM_NOT_NULL_MSG, Messages.paramNotNullMsg("test"));
    }

    @Test
    void testParamNotNumericMsg() {
        assertEquals(PARAM_NOT_NUMERIC_MSG, Messages.paramNotNumericMsg("test"));
    }

    @Test
    void testParamTypeNotSupportedMsg() {
        assertEquals(PARAM_TYPE_NOT_SUPPORTED_MSG, Messages.paramTypeNotSupportedMsg(Number.class, "", "test"));
        assertEquals(PARAM_NOT_NULL_MSG, Messages.paramTypeNotSupportedMsg(Number.class, null, "test"));
    }

}
