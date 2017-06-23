package com.smarthome.mybatis.qo;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/22/2017 5:12 PM.
 */
public class UserQo {

    private String username;

    private String password;

    private Boolean rememberMe;

    public UserQo() {}

    public UserQo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserQo(String username, String password, Boolean rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }

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

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
