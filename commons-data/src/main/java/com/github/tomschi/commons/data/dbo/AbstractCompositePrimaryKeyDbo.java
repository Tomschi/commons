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
import java.util.List;

public abstract class AbstractCompositePrimaryKeyDbo implements CompositePrimaryKeyDbo {

    private static final long serialVersionUID = 1L;

    private boolean isPrimaryKeyValuesValid(List<? extends Serializable> idList) {
        return idList != null && !idList.isEmpty() && !idList.contains(null);
    }

    @Override
    public int hashCode() {
        List<? extends Serializable> primaryKeyList = getPrimaryKeyValues();
        if (isPrimaryKeyValuesValid(primaryKeyList)) {
            return (this.getClass().getName().hashCode() * 13) + primaryKeyList.stream().mapToInt(Object::hashCode).sum();
        } else {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object obj) {
        List<? extends Serializable> primaryKeyList = getPrimaryKeyValues();
        if (isPrimaryKeyValuesValid(primaryKeyList)) {
            return (this.getClass() == obj.getClass())
                    && primaryKeyList.equals(((CompositePrimaryKeyDbo) obj).getPrimaryKeyValues());
        } else {
            return super.equals(obj);
        }
    }

}
