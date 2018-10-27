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
