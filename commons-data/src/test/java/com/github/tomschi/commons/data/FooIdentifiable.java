package com.github.tomschi.commons.data;

public class FooIdentifiable extends AbstractIdentifiable<Long> {

    private Long id;

    public FooIdentifiable(Long id) {
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
