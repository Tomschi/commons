package com.github.tomschi.commons.data.dbo.sql.testdbo;

import com.github.tomschi.commons.data.dbo.sql.AbstractSQLPrimaryKeyDbo;

/**
 * @author Tomschi
 */
public class SQLPrimaryKeyDboOne extends AbstractSQLPrimaryKeyDbo<Long> {

    private static final long serialVersionUID = -264223386966231005L;
    private Long primaryKey;

    public SQLPrimaryKeyDboOne(Long primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public Long getPrimaryKey() {
        return this.primaryKey;
    }

    @Override
    public void setPrimaryKey(Long primaryKey) {
        this.primaryKey = primaryKey;
    }

}