package com.example.pattern.proxy.jdk;

import com.example.pattern.proxy.staticed.Person;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class ZhangSan implements Person {

    @Override
    public void findLove() {
        System.out.println("身高180");
        System.out.println("人要帅");
        System.out.println("要有钱");
    }

    @Override
    public void buySomthing() {

    }

    @Override
    public void zhuFang() {
        System.out.println("要大");
        System.out.println("要干净");
        System.out.println("要独卫");
    }
}
