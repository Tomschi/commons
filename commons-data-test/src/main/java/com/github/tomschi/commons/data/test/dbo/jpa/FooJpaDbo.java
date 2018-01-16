package com.github.tomschi.commons.data.test.dbo.jpa;

import com.github.tomschi.commons.data.dbo.jpa.AbstractJpaDatabaseObject;

/**
 * @author Tomschi
 * @since 0.1.1
 */
public class FooJpaDbo extends AbstractJpaDatabaseObject<Long> {

    private static final long serialVersionUID = -2880614397836598917L;
    private Long id;

    public FooJpaDbo(Long id) {
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
