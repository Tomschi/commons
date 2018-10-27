package com.github.tomschi.commons.data.dbo;

import com.github.tomschi.commons.data.AbstractIdentifiable;

import java.io.Serializable;

public abstract class AbstractPrimaryKeyDbo<T extends Serializable> extends AbstractIdentifiable<T> implements PrimaryKeyDbo<T> {

    private static final long serialVersionUID = 1L;

}
