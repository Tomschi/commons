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
import java.text.MessageFormat;

public abstract class MessageGenerator {

    @Nonnull
    public static String getMessage(@Nonnull String message, @Nonnull Object... args) {
        MessageFormat messageFormat = new MessageFormat(message);
        return messageFormat.format(args);
    }

}
