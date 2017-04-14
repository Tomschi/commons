package com.github.tomschi.commons.jpa.dbo;

import com.github.tomschi.commons.api.dbo.BusinessKeyDbo;

/**
 * The abstract class {@link AbstractBusinessDbo} can be used
 * for database objects with a business key as primary key.
 * This implementation allows a not null primary key only.
 * This abstract class overrides the equals and hashcode methods to
 * check the primary key equality and not the java object equality.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public abstract class AbstractBusinessDbo<T> extends AbstractDatabaseObject implements BusinessKeyDbo<T> {

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
     * equals if:
     *
     * <ul>
     *     <li>The objects are the same: <code>this == obj</code></li>
     *     <li>The other object is also an instance of {@link AbstractBusinessDbo}</li>
     *     <li>The surrogate key of both objects are the same</li>
     * </ul>
     *
     * @param obj The object to equal.
     * @return <code>True</code>, if this object equals the other,
     * else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        businessKeyNotNull();

        if (obj instanceof AbstractBusinessDbo) {
            AbstractBusinessDbo<?> other = (AbstractBusinessDbo<?>) obj;
            return getBusinessKey().equals(other.getBusinessKey());
        }

        return false;
    }

    /**
     * Returns a hash value of this object. The business key is used for hash computation
     * So two objects with the same business key has the same hash code.
     *
     * @return The hash code of this object.
     */
    @Override
    public int hashCode() {
        businessKeyNotNull();
        return getBusinessKey().hashCode() * 13;
    }

}
