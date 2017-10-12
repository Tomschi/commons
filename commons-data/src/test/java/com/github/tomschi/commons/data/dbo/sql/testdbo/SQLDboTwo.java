package com.github.tomschi.commons.data.dbo.sql.testdbo;

import com.github.tomschi.commons.data.dbo.sql.AbstractSQLDatabaseObject;

/**
 * @author Tomschi
 */
public class SQLDboTwo extends AbstractSQLDatabaseObject<Long> {

    private static final long serialVersionUID = 2100148193604001376L;
    private Long id;

    public SQLDboTwo(Long id) {
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
