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

/**
 *
 * @param <T> The type of the id.
 * @author Tomschi
 * @since 0.2.1
 */
public abstract class AbstractIdentifiable<T extends Serializable> implements Identifiable<T> {

    /**
     * Returns a hash code value for the object. The value
     * is generated with the hashcode of the class name and
     * the hashcode of the id. If the id is <code>null</code>
     * {@link Object#hashCode()} is called.
     *
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        if (getId() != null) {
            return (this.getClass().getName().hashCode() * 13) + getId().hashCode();
        } else {
            return super.hashCode();
        }
    }

    /**
     * Indicates if this object is equals to another object.
     * For checking this equality the id is used.
     * Two objects are equal, if the given object is this
     * object (<code>this == obj</code>) or the given object
     * has the same class like this and both id's are equal.
     * If id is <code>null</code> the the method only check
     * if the given object is this object.
     *
     * @param obj The reference object with which to compare.
     * @return <code>True</code>, if obj equals this, else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (getId() != null) {
            return (this.getClass() == obj.getClass())
                    && getId().equals(((Identifiable<?>) obj).getId());
        } else {
            return super.equals(obj);
        }
    }

}
