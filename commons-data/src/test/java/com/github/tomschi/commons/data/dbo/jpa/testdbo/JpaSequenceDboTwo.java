package com.github.tomschi.commons.data.dbo.jpa.testdbo;

import com.github.tomschi.commons.data.dbo.jpa.AbstractJpaSequenceDbo;

/**
 * @author Tomschi
 */
public class JpaSequenceDboTwo extends AbstractJpaSequenceDbo {

    private static final long serialVersionUID = 1120208093478540280L;
    private Long id;

    public JpaSequenceDboTwo(Long id) {
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