package com.github.tomschi.commons.data.dbo.sql;

/**
 * The abstract class {@link AbstractSQLPrimaryKeyDbo} can be
 * used for database objects using a database sequence for generating
 * primary key. The primary key is of type {@link Long}.
 *
 * @see com.github.tomschi.commons.data.dbo.sql.AbstractSQLPrimaryKeyDbo
 *
 * @since 0.1.0
 * @author Tomschi
 */
public abstract class AbstractSQLSequenceDbo extends AbstractSQLPrimaryKeyDbo<Long> implements SQLSequenceDbo {

    private static final long serialVersionUID = 1L;

}
