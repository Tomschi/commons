package com.github.tomschi.commons.api.dto;

/**
 * The abstract class {@link AbstractIdentifiableDto} can be
 * used for data transfer objects with an identifier.
 * This implementation allows a not null primary key only.
 * This abstract class overrides the equals and hashcode methods to
 * check the id equality and not the java object equality.
 *
 * @param <T> The type of the key.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public abstract class AbstractIdentifiableDto<T> implements IdentifiableDto<T> {

    private static final long serialVersionUID = 1L;

    private void idNotNull() {
        if (getId() == null) throw new IllegalStateException("No id is defined.");
    }

    /**
     * Checks if this object equals the given object. The objects
     * equals if:
     * <p>
     * <ul>
     * <li>The objects are the same: <code>this == obj</code></li>
     * <li>The other object is also an instance of {@link AbstractIdentifiableDto}</li>
     * <li>The id of both objects are the same</li>
     * </ul>
     *
     * @param obj The object to equal.
     * @return <code>True</code>, if this object equals the other,
     * else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        idNotNull();

        if (obj instanceof AbstractIdentifiableDto) {
            AbstractIdentifiableDto<?> other = (AbstractIdentifiableDto<?>) obj;
            return getId().equals(other.getId());
        }

        return false;
    }

    /**
     * Returns a hash value of this object. The id is used for hash computation
     * So two objects with the same id has the same hash code.
     *
     * @return The hash code of this object.
     */
    @Override
    public int hashCode() {
        idNotNull();
        return getId().hashCode() * 13;
    }

}
