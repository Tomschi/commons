package com.github.tomschi.commons.lang;

import java.util.Optional;

public class OptionalUtils {

    public static <T> Optional<T> optionalOf(Optional<? extends T> optional) {
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

}
