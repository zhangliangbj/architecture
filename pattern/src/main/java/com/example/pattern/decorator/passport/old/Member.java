package com.example.pattern.decorator.passport.old;

/**
 * @author zhangliang
 * @date 2019/11/13 17:59
 */
public class Member {
    private String username;
    private String password;
    private String mid;
    private String info;
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

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
