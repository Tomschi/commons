package com.github.tomschi.commons.data.dbo.sql.testdbo;

import com.github.tomschi.commons.data.dbo.sql.AbstractSQLSequenceDbo;

/**
 * @author Tomschi
 */
public class SQLSequenceDboOne extends AbstractSQLSequenceDbo {

    private static final long serialVersionUID = 4740291476306011033L;
    private Long id;

    public SQLSequenceDboOne(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
