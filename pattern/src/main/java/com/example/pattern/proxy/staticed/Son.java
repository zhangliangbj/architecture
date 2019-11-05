package com.example.pattern.proxy.staticed;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class Son implements Person {

    @Override
    public void findLove() {
        System.out.println("找对象，胸大肤白貌美大长腿");
    }

    @Override
    public void buySomthing() {
        System.out.println("买东西");
    }

    @Override
    public void zhuFang() {
        System.out.println("租房");
    }
}
