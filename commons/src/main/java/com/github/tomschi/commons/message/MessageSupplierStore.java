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

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public abstract class MessageSupplierStore {

    private static final Map<String, Supplier<String>> map = new ConcurrentHashMap<>();

    public static Supplier<String> getStringSupplier(String key, String msg) {
        Supplier<String> supplier = map.get(key);
        if (Objects.nonNull(supplier)) {
            return supplier;
        }
        return map.put(key, () -> msg);
    }

    public static Supplier<String> getStringFormatSupplier(String key, String msg, Object... msgArgs) {
        Supplier<String> supplier = map.get(key);
        if (Objects.nonNull(supplier)) {
            return supplier;
        }
        return map.put(key, () -> String.format(msg, msgArgs));
    }

}
