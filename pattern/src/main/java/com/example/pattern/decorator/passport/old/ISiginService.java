package com.example.pattern.decorator.passport.old;

/**
 * @author zhangliang
 * @date 2019/11/15 16:04
 */
public interface ISiginService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password);


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password);



}
