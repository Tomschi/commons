package com.github.tomschi.commons.data.dbo;

/**
 * The interface {@link SequenceDatabaseObject} is the base interface
 * for all database objects with a {@link Long} as id.
 *
 * @author Tomschi
 * @since 0.1.1
 */
@Deprecated
public interface SequenceDatabaseObject extends PrimaryKeyDbo<Long> {
}
