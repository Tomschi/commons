package com.github.tomschi.commons.data;

public class BarIdentifiable extends AbstractIdentifiable<Long> {

    private Long id;

    public BarIdentifiable(Long id) {
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
