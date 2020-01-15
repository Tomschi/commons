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

import java.io.Serializable;
import java.util.List;

/**
 * @since 0.2.1
 * @author Tomschi
 */
public abstract class AbstractCompositeIdentifiable implements CompositeIdentifiable {

    private boolean isIdValuesValid(List<? extends Serializable> idList) {
        return idList != null && !idList.isEmpty() && !idList.contains(null);
    }

    @Override
    public int hashCode() {
        List<? extends Serializable> idList = getIdValues();
        if (isIdValuesValid(idList)) {
            return (this.getClass().getName().hashCode() * 13) + idList.stream().mapToInt(Object::hashCode).sum();
        } else {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object obj) {
        List<? extends Serializable> idList = getIdValues();
        if (isIdValuesValid(idList)) {
            return (this.getClass() == obj.getClass())
                    && idList.equals(((CompositeIdentifiable) obj).getIdValues());
        } else {
            return super.equals(obj);
        }
    }

}
