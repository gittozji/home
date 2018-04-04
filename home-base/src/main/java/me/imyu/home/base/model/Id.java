package me.imyu.home.base.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ID 模型
 * Created by imyu on 2017/12/24.
 */
public class Id implements Serializable {
    private Long id;

    private Timestamp createAt;

    private Timestamp updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}
