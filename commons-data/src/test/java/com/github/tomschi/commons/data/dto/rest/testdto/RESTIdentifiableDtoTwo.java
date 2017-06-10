package com.github.tomschi.commons.data.dto.rest.testdto;

import com.github.tomschi.commons.data.dto.rest.AbstractRESTIdentifiableDto;

/**
 * @author Tomschi
 */
public class RESTIdentifiableDtoTwo extends AbstractRESTIdentifiableDto<Long> {

    private static final long serialVersionUID = -7253656447489420223L;
    private Long id;

    public RESTIdentifiableDtoTwo(Long id) {
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
