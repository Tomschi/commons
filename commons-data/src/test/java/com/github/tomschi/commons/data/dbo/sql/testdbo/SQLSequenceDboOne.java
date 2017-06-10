package com.github.tomschi.commons.data.dbo.sql.testdbo;

import com.github.tomschi.commons.data.dbo.sql.AbstractSQLSequenceDbo;

/**
 * @author Tomschi
 */
public class SQLSequenceDboOne extends AbstractSQLSequenceDbo {

    private static final long serialVersionUID = 4740291476306011033L;
    private Long primaryKey;

    public SQLSequenceDboOne(Long primaryKey) {
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
