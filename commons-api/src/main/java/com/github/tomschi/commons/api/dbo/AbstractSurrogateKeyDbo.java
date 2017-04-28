package com.github.tomschi.commons.api.dbo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The abstract class {@link AbstractSurrogateKeyDbo} can be used
 * for database objects with a surrogate key as primary key. The
 * surrogate / primary key is type of {@link Long}, because database
 * sequences are often used for this scenario. For this reason the
 * surrogate / primary key can be null, because the key is generated
 * during the persistence operation.
 * This abstract class overrides the {@link #equals(Object)} and
 * {@link #hashCode()} methods.
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
     * are equal if the objects are the same <code>(this == obj)</code>
     * or this class equals the given object class and the both
     * surrogate keys are equal.
     * <br/>
     * If the surrogate key of this object is <code>null</code>,
     * {@link Object#equals(Object)} is used.
     *
     * @param obj The object to equal.
     * @return <code>True</code>, if this object equals the other,
     * else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof SurrogateKeyDbo) {
            SurrogateKeyDbo other = (SurrogateKeyDbo) obj;
            return !(getSurrogateKey() == null || other.getSurrogateKey() == null) &&
                new EqualsBuilder()
                    .append(this.getClass(), other.getClass())
                    .append(this.getSurrogateKey(), other.getSurrogateKey())
                    .isEquals();
        }
        return false;
    }

    /**
     * Returns a hash value of this object. If the the surrogate key
     * is not null the {@link Class#getName()} and surrogate key will
     * be used for hash computation, else {@link Object#hashCode()} is used.
     *
     * @return The hash code of this object.
     */
    @Override
    public int hashCode() {
        if (getSurrogateKey() != null) {
            return new HashCodeBuilder()
                    .append(getClass().getName())
                    .append(getSurrogateKey())
                    .toHashCode();
        }
        return super.hashCode();
    }

}
