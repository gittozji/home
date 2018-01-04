package me.imyu.home.base.model;

/**
 * 用户模型
 * Created by imyu on 2017/12/24.
 */
public class User extends Id {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}