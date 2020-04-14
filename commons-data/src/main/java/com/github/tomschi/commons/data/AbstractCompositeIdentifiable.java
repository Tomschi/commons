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
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @since 0.2.1
 * @author Tomschi
 */
public abstract class AbstractCompositeIdentifiable implements CompositeIdentifiable {

    private static final long serialVersionUID = 1L;

    private boolean isIdValuesValid(List<? extends Serializable> idList) {
        return idList != null && !idList.isEmpty() && !idList.contains(null);
    }

    /**
     * Returns a hash code value for the object. The value
     * is generated with the hash code of the class name and
     * the hash code of the id's. If the {@link List} of the
     * id's contains <code>null</code>, {@link Object#hashCode()}
     * is called.
     *
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        if (isIdValuesValid(getIdValues())) {
            Stream<Object> stream = Stream.concat(
                    Stream.of(this.getClass().getName()),
                    Stream.of(getIdValues().toArray()));
            return Objects.hash(stream.toArray());
        }

        return super.hashCode();
    }

    /**
     * Indicates if this object is equals to another object.
     * For checking this equality the {@link List} of id's
     * is used. Two objects are equal, if the given object
     * is this object (<code>this == obj</code>) or the given
     * object has the same class like this and both {@link List}
     * of id's are equal. If the {@link List} of id's contains
     * <code>null</code>, the method only check if the given
     * object is this object.
     *
     * @param obj The reference object with which to compare.
     * @return <code>True</code>, if obj equals <code>this</code>, else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        List<? extends Serializable> idList = getIdValues();
        if (isIdValuesValid(idList)) {
            return (this.getClass() == obj.getClass())
                    && idList.equals(((CompositeIdentifiable) obj).getIdValues());
        }

        return super.equals(obj);
    }

}
