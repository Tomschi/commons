package com.github.tomschi.commons.api.dbo;

/**
 * @since 0.1.0
 * @author Tomschi
 */
public class TestSurrogateKeyDbo2 extends AbstractSurrogateKeyDbo {

    private static final long serialVersionUID = 6007062588716918038L;

    private Long surrogateKey;

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getSurrogateKey() {
        return surrogateKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSurrogateKey(Long surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

}
