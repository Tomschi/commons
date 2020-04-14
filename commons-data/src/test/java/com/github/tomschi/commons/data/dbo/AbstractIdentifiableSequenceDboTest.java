/*-
 * #%L
 * commons-data
 * %%
 * Copyright (C) 2018 - 2020 Tomschi
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tomschi
 */
class AbstractIdentifiableSequenceDboTest {

    @Test
    void testSetId() {
        BarIdentifiableSequenceDbo barIdentifiableSequenceDbo = new BarIdentifiableSequenceDbo(1L);

        assertEquals("1", barIdentifiableSequenceDbo.getPrimaryKey().toString());
        assertEquals("1", barIdentifiableSequenceDbo.getId());
        assertEquals(barIdentifiableSequenceDbo.getPrimaryKey().toString(), barIdentifiableSequenceDbo.getId());

        assertThrows(IllegalArgumentException.class, () -> barIdentifiableSequenceDbo.setId("TEST"));

        barIdentifiableSequenceDbo.setId("101");
        assertEquals("101", barIdentifiableSequenceDbo.getId());
        assertEquals(101, barIdentifiableSequenceDbo.getPrimaryKey().longValue());

        barIdentifiableSequenceDbo.setId("    ");
        assertNull(barIdentifiableSequenceDbo.getId());
        assertNull(barIdentifiableSequenceDbo.getPrimaryKey());

        barIdentifiableSequenceDbo.setId(null);
        assertNull(barIdentifiableSequenceDbo.getId());
        assertNull(barIdentifiableSequenceDbo.getPrimaryKey());
    }

    private static class BarIdentifiableSequenceDbo extends AbstractIdentifiableSequenceDbo {

        private static final long serialVersionUID = 7502913920623003872L;

        private Long primaryKey;

        public BarIdentifiableSequenceDbo(Long primaryKey) {
            this.primaryKey = primaryKey;
        }

        @Override
        public Long getPrimaryKey() {
            return this.primaryKey;
        }

        @Override
        public void setPrimaryKey(Long primaryKey) {
            this.primaryKey = primaryKey;
        }

    }

}
