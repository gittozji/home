package me.imyu.home.base.model;

import java.io.Serializable;

/**
 * ID 模型
 * Created by imyu on 2017/12/24.
 */
public class Id implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
