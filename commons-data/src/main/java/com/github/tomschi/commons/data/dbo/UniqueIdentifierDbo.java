package com.github.tomschi.commons.data.dbo;

/**
 * The interface {@link UniqueIdentifierDbo} is the base interface for
 * database objects with a uid. The unique identifier (uid) is a id,
 * which is unique over all {@link UniqueIdentifierDbo} objects.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface UniqueIdentifierDbo<T> extends DatabaseObject {

    /**
     * The getter of the unique identifier.
     *
     * @return The unique identifier.
     */
    T getUid();

    /**
     * The setter of the unique identifier.
     *
     * @param uid The new unique identifier.
     */
    void setUid(T uid);

}