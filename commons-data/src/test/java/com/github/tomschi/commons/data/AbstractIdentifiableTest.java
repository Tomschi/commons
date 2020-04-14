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

/**
 * @author Tomschi
 */
class AbstractIdentifiableTest {

    @Test
    void testHashCode() {
        Identifiable<Long> barIdentifiable = new BarIdentifiable(1L);
        Identifiable<Long> fooIdentifiable = new FooIdentifiable(1L);

        assertEquals(barIdentifiable.hashCode(), barIdentifiable.hashCode());
        assertEquals(new BarIdentifiable(1L).hashCode(), new BarIdentifiable(1L).hashCode());
        assertNotEquals(barIdentifiable.hashCode(), fooIdentifiable.hashCode());
        assertNotEquals(new BarIdentifiable(null).hashCode(), new BarIdentifiable(null).hashCode());
    }

    @Test
    void testEquals() {
        Identifiable<Long> barIdentifiable1 = new BarIdentifiable(1L);
        Identifiable<Long> barIdentifiable2 = new BarIdentifiable(2L);
        Identifiable<Long> fooIdentifiable = new FooIdentifiable(1L);

        assertEquals(barIdentifiable1, barIdentifiable1);
        assertNotEquals(barIdentifiable1, barIdentifiable2);
        assertNotEquals(barIdentifiable1, fooIdentifiable);
        assertNotEquals(new BarIdentifiable(null), new BarIdentifiable(null));
    }

    private static class BarIdentifiable extends AbstractIdentifiable<Long> {

        private static final long serialVersionUID = -3976745090255523586L;

        private Long id;

        private BarIdentifiable(Long id) {
            this.id = id;
        }

        @Override
        public Long getId() {
            return this.id;
        }

        @Override
        public void setId(Long id) {
            this.id = id;
        }

    }

    private static class FooIdentifiable extends AbstractIdentifiable<Long> {

        private static final long serialVersionUID = 3179880241929901381L;

        private Long id;

        private FooIdentifiable(Long id) {
            this.id = id;
        }

        @Override
        public Long getId() {
            return this.id;
        }

        @Override
        public void setId(Long id) {
            this.id = id;
        }

    }

}
