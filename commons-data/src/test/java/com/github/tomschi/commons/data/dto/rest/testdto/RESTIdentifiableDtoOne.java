package com.github.tomschi.commons.data.dto.rest.testdto;

import com.github.tomschi.commons.data.dto.rest.AbstractRESTIdentifiableDto;

/**
 * @author Tomschi
 */
public class RESTIdentifiableDtoOne extends AbstractRESTIdentifiableDto<Long> {

    private static final long serialVersionUID = 5010284398736273483L;
    private Long id;

    public RESTIdentifiableDtoOne(Long id) {
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
