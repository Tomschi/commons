package com.github.tomschi.commons.data.dbo.jpa.testdbo;

import com.github.tomschi.commons.data.dbo.jpa.AbstractJpaSequenceDbo;

/**
 * @author Tomschi
 */
public class JpaSequenceDboOne extends AbstractJpaSequenceDbo {

    private static final long serialVersionUID = 4740291476306011033L;
    private Long id;

    public JpaSequenceDboOne(Long id) {
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
