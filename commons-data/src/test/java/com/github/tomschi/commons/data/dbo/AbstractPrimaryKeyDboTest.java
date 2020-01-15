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
package com.github.tomschi.commons.data.dbo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Tomschi
 */
class AbstractPrimaryKeyDboTest {

    @Test
    void testHashCode() {
        PrimaryKeyDbo<Long> barPrimaryKeyDbo = new BarPrimaryKeyDbo(1L);
        PrimaryKeyDbo<Long> fooPrimaryKeyDbo = new FooPrimaryKeyDbo(1L);

        int hash = barPrimaryKeyDbo.getClass().getName().hashCode() * 13 + (Integer.valueOf(1).hashCode());
        assertEquals(hash, barPrimaryKeyDbo.hashCode());

        assertNotEquals(barPrimaryKeyDbo.hashCode(), fooPrimaryKeyDbo.hashCode());
        assertNotEquals(new BarPrimaryKeyDbo(null).hashCode(), new BarPrimaryKeyDbo(null).hashCode());
    }

    @Test
    void testEquals() {
        PrimaryKeyDbo<Long> barPrimaryKeyDbo1 = new BarPrimaryKeyDbo(1L);
        PrimaryKeyDbo<Long> barPrimaryKeyDbo2 = new BarPrimaryKeyDbo(2L);
        PrimaryKeyDbo<Long> fooPrimaryKeyDbo = new FooPrimaryKeyDbo(1L);

        assertEquals(barPrimaryKeyDbo1, barPrimaryKeyDbo1);
        assertNotEquals(barPrimaryKeyDbo1, barPrimaryKeyDbo2);
        assertNotEquals(barPrimaryKeyDbo1, fooPrimaryKeyDbo);
        assertNotEquals(new BarPrimaryKeyDbo(null), new BarPrimaryKeyDbo(null));
    }

    private class BarPrimaryKeyDbo extends AbstractPrimaryKeyDbo<Long> {

        private static final long serialVersionUID = 8412755344352059966L;

        private Long primaryKey;

        public BarPrimaryKeyDbo(Long primaryKey) {
            this.primaryKey = primaryKey;
        }

        @Override
        public Long getPrimaryKey() {
            return primaryKey;
        }

        @Override
        public void setPrimaryKey(Long primaryKey) {
            this.primaryKey = primaryKey;
        }

    }

    private class FooPrimaryKeyDbo extends AbstractPrimaryKeyDbo<Long> {

        private static final long serialVersionUID = -9056338751575122354L;

        private Long primaryKey;

        public FooPrimaryKeyDbo(Long primaryKey) {
            this.primaryKey = primaryKey;
        }

        @Override
        public Long getPrimaryKey() {
            return primaryKey;
        }

        @Override
        public void setPrimaryKey(Long primaryKey) {
            this.primaryKey = primaryKey;
        }

    }

}
