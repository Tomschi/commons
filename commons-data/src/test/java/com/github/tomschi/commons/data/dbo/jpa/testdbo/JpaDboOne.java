package com.github.tomschi.commons.data.dbo.jpa.testdbo;

import com.github.tomschi.commons.data.dbo.jpa.AbstractJpaDatabaseObject;

/**
 * @author Tomschi
 */
public class JpaDboOne extends AbstractJpaDatabaseObject<Long> {

    private static final long serialVersionUID = -264223386966231005L;
    private Long id;

    public JpaDboOne(Long id) {
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