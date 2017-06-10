package com.github.tomschi.commons.data.dbo;

/**
 * The interface {@link SurrogateKeyDbo} is the base interface for
 * database objects with a surrogate key. The surrogate key is a
 * generated value, which identifies the object. Important is, that
 * the surrogate key is not globally unique.
 *
 * @param <T> The type of the surrogate key.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface SurrogateKeyDbo<T> extends DatabaseObject {

    /**
     * The getter of the surrogate key.
     *
     * @return The surrogate key.
     */
    T getSurrogateKey();

    /**
     * The setter of the surrogate key.
     *
     * @param surrogateKey The new surrogate key.
     */
    void setSurrogateKey(T surrogateKey);

}