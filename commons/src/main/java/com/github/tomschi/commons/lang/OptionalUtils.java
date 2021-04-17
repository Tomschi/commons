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
package com.github.tomschi.commons.lang;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * A utility class for {@link Optional}.
 *
 * @since 0.2.1
 * @author Tomschi
 */
public final class OptionalUtils {

    private OptionalUtils() {}

    /**
     * This method can be used for implicit type casting of {@link Optional}'s. <br>
     *
     * For example: <br>
     *
     * {@code
     * Optional<Integer> integer = Optional.of(1);
     * Optional<Number> number = OptionalUtils.optionalOf(integer);
     * }
     *
     * @param optional An {@link Optional}.
     * @param <T> The type of the optional.
     * @return A {@link Optional} of type T.
     */
    @Nonnull
    public static <T> Optional<T> optionalOf(@Nonnull Optional<? extends T> optional) {
        return Optional.ofNullable(optional.orElse(null));
    }

}
