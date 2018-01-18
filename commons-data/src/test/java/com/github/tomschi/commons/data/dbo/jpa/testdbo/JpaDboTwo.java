package com.github.tomschi.commons.data.dbo.jpa.testdbo;

import com.github.tomschi.commons.data.dbo.jpa.AbstractJpaDatabaseObject;

/**
 * @author Tomschi
 */
public class JpaDboTwo extends AbstractJpaDatabaseObject<Long> {

    private static final long serialVersionUID = 2100148193604001376L;
    private Long id;

    public JpaDboTwo(Long id) {
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
