package com.github.tomschi.commons.data.dbo.sql.testdbo;

import com.github.tomschi.commons.data.dbo.sql.AbstractSQLSequenceDbo;

/**
 * @author Tomschi
 */
public class SQLSequenceDboTwo extends AbstractSQLSequenceDbo {

    private static final long serialVersionUID = 1120208093478540280L;
    private Long primaryKey;

    public SQLSequenceDboTwo(Long primaryKey) {
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