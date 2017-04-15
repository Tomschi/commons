package com.github.tomschi.commons.api.dbo;

/**
 * The interface {@link SurrogateKeyDbo} is the base interface for
 * database objects with surrogate keys. The key are usually generated
 * with an database sequence. So the surrogate key is type of {@link Long}.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface SurrogateKeyDbo extends KeyDatabaseObject<Long> {

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

    /**
     * Indicates if the database object is persisted or not.
     *
     * @return <code>True</code>, if dbo is persisted, else <code>false</code>
     */
    boolean isPersisted();

}
