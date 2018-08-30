package com.yiran.mvc.pojo;

import java.io.Serializable;

public class BaseDict implements Serializable {
    private Integer baseId;
    private String baseName;

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public String toString() {
        return "BaseDict{" +
                "baseId=" + baseId +
                ", baseName='" + baseName + '\'' +
                '}';
    }
}
