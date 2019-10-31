package com.example.pattern.simplefactory.impl;

import com.example.pattern.Milk;

/**
 * @author zhangliang
 * @date 2019/10/30
 */
public class SimpleFactoryTest {

    public static void main (String[] args){
        SimpleFactory simpleFactory = new SimpleFactory();
        Milk result = simpleFactory.getMilk("特仑苏");
        System.out.println(result.getName());
    }
}
