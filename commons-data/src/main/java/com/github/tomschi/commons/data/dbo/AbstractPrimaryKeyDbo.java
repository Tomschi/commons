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

import java.io.Serializable;

/**
 * @since 0.2.1
 * @author Tomschi
 */
public abstract class AbstractPrimaryKeyDbo<T extends Serializable> implements PrimaryKeyDbo<T> {

    private static final long serialVersionUID = 1L;

    @Override
    public int hashCode() {
        if (getPrimaryKey() != null) {
            return (this.getClass().getName().hashCode() * 13) + getPrimaryKey().hashCode();
        } else {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (getPrimaryKey() != null) {
            return (this.getClass() == obj.getClass())
                    && getPrimaryKey().equals(((PrimaryKeyDbo<?>) obj).getPrimaryKey());
        } else {
            return super.equals(obj);
        }
    }

}
