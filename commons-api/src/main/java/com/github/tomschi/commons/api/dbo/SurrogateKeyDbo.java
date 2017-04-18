package com.github.tomschi.commons.api.dbo;

/**
 * The interface {@link SurrogateKeyDbo} is the base interface for
 * database objects with a surrogate key. The key is usually generated
 * by a database sequence, so the surrogate key is type of {@link Long}.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface SurrogateKeyDbo extends DatabaseObject {

    /**
     * The getter of the surrogate key.
     *
     * @return The surrogate key.
     */
    Long getSurrogateKey();

    /**
     * The setter of the surrogate key.
     *
     * @param surrogateKey The new surrogate key.
     */
    void setSurrogateKey(Long surrogateKey);

}
