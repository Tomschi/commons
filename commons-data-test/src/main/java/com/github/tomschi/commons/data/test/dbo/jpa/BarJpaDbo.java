package com.github.tomschi.commons.data.test.dbo.jpa;

import com.github.tomschi.commons.data.dbo.jpa.AbstractJpaDatabaseObject;

/**
 * @author Tomschi
 * @since 0.1.1
 */
public class BarJpaDbo extends AbstractJpaDatabaseObject<Long> {

    private static final long serialVersionUID = 2100148193604001376L;
    private Long id;

    public BarJpaDbo(Long id) {
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
