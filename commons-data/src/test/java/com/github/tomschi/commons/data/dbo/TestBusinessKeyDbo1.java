package com.github.tomschi.commons.data.dbo;

/**
 * @since 0.1.0
 * @author Tomschi
 */
public class TestBusinessKeyDbo1 extends AbstractBusinessKeyDbo<Long> {

    private static final long serialVersionUID = -354909250818332455L;

    private Long businessKey;

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getBusinessKey() {
        return businessKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBusinessKey(Long businessKey) {
        this.businessKey = businessKey;
    }

}