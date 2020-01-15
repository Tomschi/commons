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
package com.github.tomschi.commons.data.dto.rest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tomschi
 */
class AbstractRESTIdentifiableDtoTest {

    @Test
    void testEqualsHashCodeSuccess() {
        RESTIdentifiableDto<Long> first = new BarRESTIdentifiableDto(1L);
        RESTIdentifiableDto<Long> second = new BarRESTIdentifiableDto(1L);
        RESTIdentifiableDto<Long> third = new BarRESTIdentifiableDto(null);
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        assertTrue(first.equals(first));
        assertFalse(third.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    void testEqualsFails() {
        RESTIdentifiableDto<Long> first = new BarRESTIdentifiableDto(1L);
        RESTIdentifiableDto<Long> second = new BarRESTIdentifiableDto(2L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(null);
        second.setId(null);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        first.setId(1L);
        second = new FooRESTIdentifiableDto(1L);
        assertFalse(first.equals(second));
        assertNotEquals(first.hashCode(), second.hashCode());

        assertNotEquals(first.hashCode(), new Long(1).hashCode());

        assertTrue(first.equals(first));
        assertEquals(first.hashCode(), first.hashCode());
    }

    private class BarRESTIdentifiableDto extends AbstractRESTIdentifiableDto<Long> {

        private static final long serialVersionUID = 8000065652142550795L;
        private Long id;

        private BarRESTIdentifiableDto(Long id) {
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

    private class FooRESTIdentifiableDto extends AbstractRESTIdentifiableDto<Long> {

        private static final long serialVersionUID = 8355580289509165199L;
        private Long id;

        private FooRESTIdentifiableDto(Long id) {
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
