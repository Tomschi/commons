package com.github.tomschi.commons.springdatajpa.dbo;

public class FooJpaCompositeKey extends AbstractJpaCompositeKey<Long, Long> {

    private static final long serialVersionUID = -35924151871556942L;

    private Long firstId;
    private Long secondId;

    public FooJpaCompositeKey(Long firstId, Long secondId) {
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
