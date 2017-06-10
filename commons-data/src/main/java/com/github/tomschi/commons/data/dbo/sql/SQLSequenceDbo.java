package com.github.tomschi.commons.data.dbo.sql;

/**
 * The interface {@link SQLSequenceDbo} is the base interface for
 * all SQL based database objects, where the primary key is generated
 * by a database sequence. The primary key is of type {@link Long}.
 *
 * @since 0.1.0
 * @author Tomschi
 */
public interface SQLSequenceDbo extends SQLPrimaryKeyDbo<Long> {
}
