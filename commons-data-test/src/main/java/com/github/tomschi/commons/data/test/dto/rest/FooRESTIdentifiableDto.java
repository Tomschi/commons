package com.github.tomschi.commons.data.test.dto.rest;

import com.github.tomschi.commons.data.dto.rest.AbstractRESTIdentifiableDto;

/**
 * @author Tomschi
 * @since 0.1.1
 */
public class FooRESTIdentifiableDto extends AbstractRESTIdentifiableDto<Long> {

    private static final long serialVersionUID = 8242819313369504352L;
    private Long id;

    public FooRESTIdentifiableDto(Long id) {
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
