package com.github.tomschi.commons.data.dto.rest;

/**
 * The abstract class {@link AbstractRESTIdentifiableDto} can be used
 * for rest data transfer objects with an identifier. This class
 * overrides the {@link #equals(Object)} and {@link #hashCode()} method.
 *
 * @param <T> The type of the id.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public abstract class AbstractRESTIdentifiableDto<T> implements RESTIdentifiableDto<T> {

    private static final long serialVersionUID = 1L;

    /**
     * Indicates if this object is equals to another object.
     * For checking this equality the identifier is used.
     * Two objects are equal, if the given object is this
     * object (<code>this == obj</code>) or the given object
     * has the same class like this and both identifiers
     * are equal. If identifier is <code>null</code> the
     * the method only check if the given object is this object.
     *
     * @param obj The reference object with which to compare.
     * @return <code>True</code>, if obj equals this, else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (getId() == null) return (this == obj);
        return (this.getClass() == obj.getClass())
                && this.getId().equals(((RESTIdentifiableDto<?>) obj).getId());
    }

    /**
     * Returns a hash code value for the object. The value
     * is generated with the hashcode of the class name and
     * the hashcode of the identifier. If the identifier
     * is <code>null</code> {@link Object#hashCode()} is called.
     *
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        if (getId() == null) return super.hashCode();
        return this.getClass().getName().hashCode() * 13 + getId().hashCode();
    }

}
