package com.github.tomschi.commons.springdatajpa.dbo;

import com.github.tomschi.commons.data.dbo.jpa.AbstractJpaSequenceDbo;

/**
 * @author Tomschi
 * @since 0.1.0
 */
public class BarJpaSequenceDbo extends AbstractJpaSequenceDbo {

    private static final long serialVersionUID = 2476238400765422288L;
    private Long id;

    public BarJpaSequenceDbo(Long id) {
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
