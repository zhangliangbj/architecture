package com.example;

/**
 * @author zhangliang
 * @date 2019/12/8 13:55
 */
public class HelloImpl implements IHello {
    @Override
    public String sayHello(String msg) {
        return "Hello"+msg;
    }
}
