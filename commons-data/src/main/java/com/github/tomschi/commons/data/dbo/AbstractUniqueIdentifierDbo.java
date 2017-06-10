package com.github.tomschi.commons.data.dbo;

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
public abstract class AbstractUniqueIdentifierDbo implements UniqueIdentifierDbo, PrimaryKeyDbo<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Checks if this object equals the given object. The objects
     * are equal if the objects are the same <code>(this == obj)</code>
     * or the uid is the same.
     *
     * @param obj The object to equal.
     * @return <code>True</code>, if this object equals the other,
     * else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof UniqueIdentifierDbo) {
            UniqueIdentifierDbo other = (UniqueIdentifierDbo) obj;
            return !(getUid() == null || other.getUid() == null) &&
                    new EqualsBuilder()
                            .append(this.getUid(), other.getUid())
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
        if (getUid() != null) {
            return new HashCodeBuilder()
                    .append(getUid())
                    .toHashCode();
        }
        return super.hashCode();
    }
}
