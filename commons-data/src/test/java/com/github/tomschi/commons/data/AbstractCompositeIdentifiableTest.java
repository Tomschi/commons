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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Tomschi
 */
class AbstractCompositeIdentifiableTest {

    @Test
    void testHashCode() {
        List<? extends Serializable> idList1 = Arrays.asList(1L, "KEY");
        List<? extends Serializable> idList2 = Arrays.asList(1L, "KEY");

        CompositeIdentifiable barCompositeIdentifiable = new BarCompositeIdentifiable(idList1);
        CompositeIdentifiable fooCompositeIdentifiable = new FooCompositeIdentifiable(idList2);

        assertEquals(barCompositeIdentifiable.hashCode(), barCompositeIdentifiable.hashCode());
        assertEquals(new BarCompositeIdentifiable(idList1).hashCode(), new BarCompositeIdentifiable(idList1).hashCode());
        assertEquals(new BarCompositeIdentifiable(idList1).hashCode(), new BarCompositeIdentifiable(idList2).hashCode());
        assertNotEquals(barCompositeIdentifiable.hashCode(), fooCompositeIdentifiable.hashCode());
        assertNotEquals(new BarCompositeIdentifiable(null).hashCode(), new BarCompositeIdentifiable(null).hashCode());
    }

    @Test
    void testEquals() {
        List<? extends Serializable> idList1 = Arrays.asList(1L, "KEY");
        List<? extends Serializable> idList2 = Arrays.asList(1L, "KEY");
        List<? extends Serializable> idList3 = Arrays.asList(2L, "KEY");

        CompositeIdentifiable barCompositeIdentifiable1 = new BarCompositeIdentifiable(idList1);
        CompositeIdentifiable barCompositeIdentifiable2 = new BarCompositeIdentifiable(idList2);
        CompositeIdentifiable barCompositeIdentifiable3 = new BarCompositeIdentifiable(idList3);

        CompositeIdentifiable fooCompositeIdentifiable1 = new FooCompositeIdentifiable(idList1);

        assertEquals(barCompositeIdentifiable1, barCompositeIdentifiable1);
        assertEquals(barCompositeIdentifiable1, barCompositeIdentifiable2);
        assertNotEquals(barCompositeIdentifiable1, barCompositeIdentifiable3);
        assertNotEquals(new BarCompositeIdentifiable(null), barCompositeIdentifiable1);
        assertNotEquals(new BarCompositeIdentifiable(new ArrayList<>()), barCompositeIdentifiable1);
        assertNotEquals(new BarCompositeIdentifiable(Arrays.asList(null, null)), barCompositeIdentifiable1);
        assertNotEquals(barCompositeIdentifiable1, fooCompositeIdentifiable1);
        assertNotEquals(new BarCompositeIdentifiable(null), new BarCompositeIdentifiable(null));
    }

    private static class BarCompositeIdentifiable extends AbstractCompositeIdentifiable {

        private static final long serialVersionUID = 1313684911625298411L;

        private final List<? extends Serializable> idValues;

        private BarCompositeIdentifiable(List<? extends Serializable> idValues) {
            this.idValues = idValues;
        }

        @Override
        public List<? extends Serializable> getIdValues() {
            return this.idValues;
        }

    }

    private static class FooCompositeIdentifiable extends AbstractCompositeIdentifiable {

        private static final long serialVersionUID = -952008689726740335L;

        private final List<? extends Serializable> idValues;

        private FooCompositeIdentifiable(List<? extends Serializable> idValues) {
            this.idValues = idValues;
        }

        @Override
        public List<? extends Serializable> getIdValues() {
            return this.idValues;
        }

    }

}
