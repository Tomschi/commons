package com.github.tomschi.commons.data.dbo.sql;

/**
 * The abstract class {@link AbstractSQLDatabaseObject} can be
 * used for database objects using a database sequence for generating
 * id. The id is of type {@link Long}.
 *
 * @author Tomschi
 * @see AbstractSQLDatabaseObject
 * @since 0.1.0
 */
public abstract class AbstractSQLSequenceDbo extends AbstractSQLDatabaseObject<Long> implements SQLSequenceDbo {

    private static final long serialVersionUID = 1L;

}
