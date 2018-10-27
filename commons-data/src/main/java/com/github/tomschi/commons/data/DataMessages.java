package com.github.tomschi.commons.data;

import com.github.tomschi.commons.message.MessageSupplierStore;

import java.util.function.Supplier;

public class DataMessages {

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
