package com.github.tomschi.commons.api.dto.rest;

/**
 * @since 0.1.0
 * @author Tomschi
 */
public class TestIdentifiableRestDto1 extends AbstractIdentifiableRestDto<Long> {

    private static final long serialVersionUID = 613116266201129529L;

    private Long id;

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
