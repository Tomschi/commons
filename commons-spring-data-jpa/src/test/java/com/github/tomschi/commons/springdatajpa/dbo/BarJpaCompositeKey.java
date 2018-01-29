package com.github.tomschi.commons.springdatajpa.dbo;

public class BarJpaCompositeKey extends AbstractJpaCompositeKey<Long, Long> {

    private static final long serialVersionUID = 8057196728623428563L;

    private Long firstId;
    private Long secondId;

    public BarJpaCompositeKey(Long firstId, Long secondId) {
        this.firstId = firstId;
        this.secondId = secondId;
    }

    @Override
    protected Long getFirstId() {
        return this.firstId;
    }

    @Override
    protected Long getSecondId() {
        return this.secondId;
    }

}
