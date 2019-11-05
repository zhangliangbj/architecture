package com.example.pattern.proxy.staticed;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();

    }

}
