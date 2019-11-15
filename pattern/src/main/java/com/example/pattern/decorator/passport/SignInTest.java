package com.example.pattern.decorator.passport;

import com.example.pattern.decorator.passport.old.SiginService;
import com.example.pattern.decorator.passport.upgrede.ISigninForThirdService;
import com.example.pattern.decorator.passport.upgrede.SigninForThirdService;

/**
 * @author zhangliang
 * @date 2019/11/15 15:57
 */
public class SignInTest {

    public static void main(String[] args) {

        //原来的功能依旧对外开放，依旧保留
        //新的功能同样的也可以使用

        ISigninForThirdService signinForThirdService = new SigninForThirdService(new SiginService());

        signinForThirdService.loginForQQ("xxssdsd");


//        Decorator
//        Wrapper


        /*

            ===============================================================------
            装饰器模式                          |   适配器模式
            -----------------------------------+---------------------------------
            是一种非常特别的适配器模式            |  可以不保留层级关系
            -----------------------------------+---------------------------------
            装饰者和被装饰者都要实现同一个接口     |  适配者和被适配者没有必然的层级联系
            主要目的是为了扩展，依旧保留OOP关系    |  通常采用代理或者继承形式进行包装
            -----------------------------------+----------------------------------
            满足is-a的关系                      |   满足has-a
            -----------------------------------+----------------------------------
            注重的是覆盖、扩展                   |   注重兼容、转换
            -----------------------------------+----------------------------------


        */


    }
}
