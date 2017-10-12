package com.github.tomschi.commons.data.dbo.sql.testdbo;

import com.github.tomschi.commons.data.dbo.sql.AbstractSQLSequenceDbo;

/**
 * @author Tomschi
 */
public class SQLSequenceDboTwo extends AbstractSQLSequenceDbo {

    private static final long serialVersionUID = 1120208093478540280L;
    private Long id;

    public SQLSequenceDboTwo(Long id) {
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