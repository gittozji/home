package me.imyu.home.file.model;

import me.imyu.home.base.model.Id;

import java.sql.Timestamp;

/**
 * Created by imyu on 2018-04-04.
 */
public class Tag extends Id{
    String name;
    Long userId;
    Timestamp createAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Timestamp getCreateAt() {
        return createAt;
    }

    @Override
    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
