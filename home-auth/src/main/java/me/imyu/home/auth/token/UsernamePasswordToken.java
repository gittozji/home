package me.imyu.home.auth.token;

/**
 * 用户名密码token
 *
 * Created by imyu on 2018-01-04.
 */
public class UsernamePasswordToken implements Token {
    String username;
    String password;

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
