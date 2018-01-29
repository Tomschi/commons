package com.github.tomschi.commons.springdatajpa.dbo;

import java.io.Serializable;

/**
 * The {@link AbstractJpaCompositeKey} can be used as base class for
 * JPA IdClass. Equals and hash code method is already implemented.
 *
 * @param <T> The type of the first id.
 * @param <S> The type of the second id.
 *
 * @author Tomschi
 * @since 0.1.2
 */
public abstract class AbstractJpaCompositeKey<T, S> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Returns the first id.
     * @return The id of type {@link T}
     */
    protected abstract T getFirstId();

    /**
     * Returns the second id.
     * @return The id of type {@link S}
     */
    protected abstract S getSecondId();

    /**
     * Indicates if this object is equals to another object.
     * For checking this equality the first id and the second
     * id is used. Two objects are equal, if the given object
     * is this object (<code>this == obj</code>) or the given
     * object has the same class like this and both id's are equal.
     *
     * @param obj The reference object with which to compare.
     * @return <code>True</code>, if obj equals this, else <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        return this == obj
                || this.getClass() == obj.getClass()
                && getFirstId().equals(((AbstractJpaCompositeKey<?, ?>) obj).getFirstId())
                && getSecondId().equals(((AbstractJpaCompositeKey<?, ?>) obj).getSecondId());
    }

    /**
     * Returns a hash code value for the object. The value
     * is generated with the hashcode of the class name and
     * the hashcode of the id's.
     *
     * @return A hash code value for the object.
     */
    @Override
    public int hashCode() {
        return (this.getClass().getName().hashCode() * 13) + getFirstId().hashCode() + getSecondId().hashCode();
    }

}
