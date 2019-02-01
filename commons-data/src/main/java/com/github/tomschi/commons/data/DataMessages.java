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
package com.github.tomschi.commons.data;

import com.github.tomschi.commons.message.MessageSupplierStore;

import java.util.function.Supplier;

public abstract class DataMessages {

    private static final String CREATE_BEFORE_SAVE_MSG = "The object must be created first. Then the save method can be called.";
    private static final String PARAM_NOT_PERSIST_MSG = "The %s must be persisted first.";

    private static String generateKey(String value) {
        return "DATA_" + value.toUpperCase();
    }

    private static String generateKey(String postfix, String value) {
        return generateKey(value) + "_" + postfix.toUpperCase();
    }

    public static Supplier<String> createBeforeSave() {
        return MessageSupplierStore.getStringSupplier(generateKey("CREATE_BEFORE_SAVE"), CREATE_BEFORE_SAVE_MSG);
    }

    public static Supplier<String> paramNotPersistMsg(String parameterName) {
        String key = generateKey(parameterName, "PARAM_NOT_PERSIST");
        return MessageSupplierStore.getStringFormatSupplier(key, PARAM_NOT_PERSIST_MSG, parameterName);
    }

}
