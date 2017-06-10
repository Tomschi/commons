package com.github.tomschi.commons.data.dbo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The abstract class {@link AbstractBusinessKeyDbo} can be used
 * for database objects with a business key as primary key.
 * The business key must not be <code>null</code>.
 * This abstract class overrides the {@link #equals(Object)} and
 * {@link #hashCode()} methods.
 *
 * @param <T> The type of the business key.
 *
 * @author Tomschi
 * @since 0.1.0
 */
public abstract class AbstractBusinessKeyDbo<T> implements BusinessKeyDbo<T>, PrimaryKeyDbo<T> {

    private static final long serialVersionUID = 1L;

    /**
     * The getter of the primary key. This getter returns the
     * same value as {@link #getBusinessKey()}. The primary key
     * must not be null.
     *
     * @return The primary key.
     */
    @Override
    public T getPrimaryKey() {
        return getBusinessKey();
    }

    /**
     * The setter of the primary key. This method calls
     * {@link #setBusinessKey(Object)}, because the business
     * key is the primary key in this implementation.
     *
     * @param primaryKey The new primary key.
     */
    @Override
    public void setPrimaryKey(T primaryKey) {
        setBusinessKey(primaryKey);
    }

    /**
     * Checks if the business key is not null, else an
     * {@link IllegalStateException} is thrown.
     *
     * @throws IllegalStateException When business key is null.
     */
    private void businessKeyNotNull() {
        if (getBusinessKey() == null) throw new IllegalStateException("No business key is defined.");
    }

    /**
     * Checks if this object equals the given object. The objects
     * are equal if the objects are the same <code>(this == obj)</code>
     * or this class equals the given object class and the both
     * business keys are equal.
     * <br/>
     * If the business key of this object is <code>null</code>,
     * the method throws a {@link IllegalStateException}.
     *
     * @param obj The object to equal.
     * @return <code>True</code>, if this object equals the other,
     * else <code>false</code>.
     *
     * @throws IllegalStateException When business key of this object is null.
     */
    @Override
    public boolean equals(Object obj) {
        businessKeyNotNull();
        return (this == obj) || (obj instanceof BusinessKeyDbo) &&
                (new EqualsBuilder().append(this.getClass(), obj.getClass())
                    .append(this.getBusinessKey(), ((BusinessKeyDbo<?>) obj).getBusinessKey()).isEquals());
    }

    /**
     * Returns a hash value of this object. The {@link Class#getName()} and
     * business key will be used for hash computation. If the business key of
     * this object is <code>null</code> the method throws a {@link IllegalStateException}.
     *
     * @return The hash code of this object.
     *
     * @throws IllegalStateException When business key of this object is null.
     */
    @Override
    public int hashCode() {
        businessKeyNotNull();
        return new HashCodeBuilder()
                .append(getClass().getName())
                .append(getBusinessKey())
                .toHashCode();
    }

}
