package com.github.tomschi.commons.data;

import java.io.Serializable;
import java.util.List;

public interface CompositeIdentifiable {

    List<? extends Serializable> getIdValues();

}
