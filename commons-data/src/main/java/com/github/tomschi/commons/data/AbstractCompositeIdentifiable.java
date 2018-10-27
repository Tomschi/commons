package com.github.tomschi.commons.data;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCompositeIdentifiable implements CompositeIdentifiable {

    @Override
    public int hashCode() {
        List<? extends Serializable> idList = getIdValues();
        if (idList.contains(null)) return super.hashCode();
        return (this.getClass().getName().hashCode() * 13) + idList.stream().mapToInt(Object::hashCode).sum();
    }

    @Override
    public boolean equals(Object obj) {
        List<? extends Serializable> idList = getIdValues();
        if (idList.contains(null)) return super.equals(obj);
        return (this.getClass() == obj.getClass())
                && idList.equals(((CompositeIdentifiable) obj).getIdValues());
    }

}
