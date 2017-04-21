package com.github.tomschi.commons.api.dbo;

/**
 * The abstract class {@link AbstractSurrogateKeyDbo} can be used
 * for database objects with a surrogate key as primary key.
 * This implementation allows a nullable primary key, because the
 * key is generated during the persistence operation.
 * This abstract class overrides the equals and hashcode methods to
 * check the surrogate key equality and not the java object equality.
 *
 * @author Tomschi
 * @since 0.1.0
 */
public abstract class AbstractSurrogateKeyDbo implements SurrogateKeyDbo, PrimaryKeyDbo<Long> {

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
     * Checks if this object equals the given object. The objects
     * equals if:
     * <p>
     * <ul>
     * <li>The objects are the same: <code>this == obj</code></li>
     * <li>The other object has the same type</li>
     * <li>The surrogate key of both objects are the same</li>
     * </ul>
     *
     * @param obj The object to equal.
     * @return <code>True</code>, if this object equals the other,
     * else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj != null && this.getClass().equals(obj.getClass())) {
            AbstractSurrogateKeyDbo other = (AbstractSurrogateKeyDbo) obj;
            if (getSurrogateKey() != null && other.getSurrogateKey() != null) {
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
        if (getSurrogateKey() != null) {
            return getSurrogateKey().hashCode() * 13;
        }
        return super.hashCode();
    }

}
