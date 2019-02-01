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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AbstractIdentifiableTest {

    @Test
    void testHashCode() {
        BarIdentifiable barIdentifiable = new BarIdentifiable(1L);
        FooIdentifiable fooIdentifiable = new FooIdentifiable(1L);

        int hash = barIdentifiable.getClass().getName().hashCode() * 13 + (Integer.valueOf(1).hashCode());
        assertEquals(hash, barIdentifiable.hashCode());

        assertNotEquals(barIdentifiable.hashCode(), fooIdentifiable.hashCode());
    }

    @Test
    void testEquals() {
        BarIdentifiable barIdentifiable = new BarIdentifiable(1L);
        FooIdentifiable fooIdentifiable = new FooIdentifiable(1L);

        assertEquals(barIdentifiable, barIdentifiable);
        assertNotEquals(barIdentifiable, fooIdentifiable);
    }
}
