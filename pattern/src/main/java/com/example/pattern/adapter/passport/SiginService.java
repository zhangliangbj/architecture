package com.example.pattern.adapter.passport;

import com.example.pattern.adapter.Member;
import com.example.pattern.adapter.ResultMsg;

/**
 * @author zhangliang
 * @date 2019/11/13 18:10
 */
public class SiginService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password){
        return  new ResultMsg("200","注册成功",new Member());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return  new ResultMsg("200","登录成功",new Member());
    }
}
