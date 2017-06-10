package com.github.tomschi.commons.data.dbo.sql.testdbo;

import com.github.tomschi.commons.data.dbo.sql.AbstractSQLPrimaryKeyDbo;

/**
 * @author Tomschi
 */
public class SQLPrimaryKeyDboTwo extends AbstractSQLPrimaryKeyDbo<Long> {

    private static final long serialVersionUID = 2100148193604001376L;
    private Long primaryKey;

    public SQLPrimaryKeyDboTwo(Long primaryKey) {
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
