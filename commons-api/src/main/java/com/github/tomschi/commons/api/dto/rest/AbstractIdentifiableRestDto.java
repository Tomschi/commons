package com.github.tomschi.commons.api.dto.rest;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The abstract class {@link AbstractIdentifiableRestDto} can be
 * used for rest data transfer objects with an identifier.
 * This implementation allows a not null primary key only.
 * This abstract class overrides the equals and hashcode methods to
 * check the id equality and not the java object equality.
 *
 * @param <T> The type of the id.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public abstract class AbstractIdentifiableRestDto<T> implements IdentifiableRestDto<T> {

    private static final long serialVersionUID = 1L;

    /**
     * Checks if the id is not null, else an
     * {@link IllegalStateException} is thrown.
     *
     * @throws IllegalStateException When id null.
     */
    private void idNotNull() {
        if (getId() == null) throw new IllegalStateException("No id is defined.");
    }

    /**
     * Checks if this object equals the given object. The objects
     * are equal if the objects are the same <code>(this == obj)</code>
     * or this class equals the given object class and the both
     * id's are equal.
     * <br/>
     * If the id of this object is <code>null</code>,
     * the method throws a {@link IllegalStateException}.
     *
     * @param obj The object to equal.
     * @return <code>True</code>, if this object equals the other,
     * else <code>false</code>.
     *
     * @throws IllegalStateException When id of this object is null.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        idNotNull();

        if (obj != null && this.getClass().equals(obj.getClass())) {
            AbstractIdentifiableRestDto<?> other = (AbstractIdentifiableRestDto<?>) obj;
            return getId().equals(other.getId());
        }

        return false;
    }

    /**
     * Returns a hash value of this object. The {@link Class#getName()}
     * and id will be used for hash computation. If the id of this object is
     * <code>null</code> the method throws a {@link IllegalStateException}.
     *
     * @return The hash code of this object.
     *
     * @throws IllegalStateException When id of this object is null.
     */
    @Override
    public int hashCode() {
        idNotNull();
        return new HashCodeBuilder()
                .append(getClass().getName())
                .append(getId())
                .toHashCode();
    }

}
