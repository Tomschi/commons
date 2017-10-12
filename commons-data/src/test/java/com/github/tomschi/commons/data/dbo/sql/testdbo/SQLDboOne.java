package com.github.tomschi.commons.data.dbo.sql.testdbo;

import com.github.tomschi.commons.data.dbo.sql.AbstractSQLDatabaseObject;

/**
 * @author Tomschi
 */
public class SQLDboOne extends AbstractSQLDatabaseObject<Long> {

    private static final long serialVersionUID = -264223386966231005L;
    private Long id;

    public SQLDboOne(Long id) {
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