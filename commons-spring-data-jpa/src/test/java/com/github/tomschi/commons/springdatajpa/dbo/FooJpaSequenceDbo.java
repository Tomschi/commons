package com.github.tomschi.commons.springdatajpa.dbo;

import com.github.tomschi.commons.data.dbo.jpa.AbstractJpaSequenceDbo;

/**
 * @author Tomschi
 * @since 0.1.0
 */
public class FooJpaSequenceDbo extends AbstractJpaSequenceDbo {

    private static final long serialVersionUID = 4075372984930129344L;
    private Long id;

    public FooJpaSequenceDbo(Long id) {
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
