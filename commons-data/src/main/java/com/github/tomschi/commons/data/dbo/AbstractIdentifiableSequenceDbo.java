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

import com.github.tomschi.commons.data.Identifiable;

/**
 * @since 0.2.2
 * @author Tomschi
 */
public abstract class AbstractIdentifiableSequenceDbo extends AbstractPrimaryKeyDbo<Long> implements Identifiable<String> {

    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return (getPrimaryKey() != null) ? getPrimaryKey().toString() : null;
    }

    /**
     * The setter of the id. The parameter mus be
     * a valid {@link Long} value, else a
     * {@link IllegalArgumentException} is thrown.
     *
     * @param id The id to set.
     * @throws IllegalArgumentException If parameter is not a valid {@link Long} value.
     */
    @Override
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            setPrimaryKey(null);
            return;
        }

        try {
            setPrimaryKey(Long.parseLong(id));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The given id is not a valid Long value.", e);
        }
    }

}
