package com.github.tomschi.commons.jpa.dbo;

import com.github.tomschi.commons.api.dbo.SurrogateKeyDbo;

/**
 * The abstract class {@link AbstractSurrogateKeyDbo} can be used
 * for database objects with a surrogate key as primary key.
 * This implementation allows a nullable primary key, because the
 * key is given, after the object is persisted.
 * This abstract class overrides the equals and hashcode methods to
 * check the primary key equality and not the java object equality.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public abstract class AbstractSurrogateKeyDbo extends AbstractDatabaseObject implements SurrogateKeyDbo {

    private static final long serialVersionUID = 1L;

    /**
     * The getter of the primary key. This getter returns the
     * same value as {@link #getSurrogateKey()}.
     *
     * @return The primary key or <code>null</code>, if the object
     * is not persisted.
     */
    @Override
    public Long getPrimaryKey() {
        return getSurrogateKey();
    }

    /**
     * The setter of the primary key. This method calls
     * {@link #setSurrogateKey(Long)}, because the surrogate
     * key is the primary key in this implementation.
     *
     * @param primaryKey The new primary key.
     */
    @Override
    public void setPrimaryKey(Long primaryKey) {
        setSurrogateKey(primaryKey);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPersisted() {
        return getSurrogateKey() != null;
    }

    /**
     * Checks if this object equals the given object. The objects
     * equals if:
     *
     * <ul>
     *     <li>The objects are the same: <code>this == obj</code></li>
     *     <li>The other object is also an instance of {@link AbstractSurrogateKeyDbo}</li>
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

        if (obj instanceof AbstractSurrogateKeyDbo) {
            AbstractSurrogateKeyDbo other = (AbstractSurrogateKeyDbo) obj;
            if (isPersisted() && other.isPersisted()) {
                return getSurrogateKey().equals(other.getSurrogateKey());
            }
        }

        return false;
    }

    /**
     * Returns a hash value of this object. If the object is persisted
     * the surrogate key is used for hash computation, else {@link Object#hashCode()}
     * is used.
     * So two objects with the same surrogate key has the same hash code.
     *
     * @return The hash code of this object.
     */
    @Override
    public int hashCode() {
        if (isPersisted()) {
            return getSurrogateKey().hashCode() * 13;
        }
        return super.hashCode();
    }

}
