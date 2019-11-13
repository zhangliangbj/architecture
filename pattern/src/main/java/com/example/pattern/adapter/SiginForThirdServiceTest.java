package com.example.pattern.adapter;

import com.example.pattern.adapter.passport.SignInForThirdService;

/**
 * @author zhangliang
 * @date 2019/11/13 18:17
 */
public class SiginForThirdServiceTest {

    public static void main(String[] args) {
        SignInForThirdService signInForThirdService = new SignInForThirdService();
        ResultMsg resultMsg = signInForThirdService.loginForQQ("kdkkdkfkfkfkfkfk");
        System.out.println(resultMsg.getCode());
    }

}
