package com.example.pattern.factory;

/**
 * @author zhangliang
 * @date 2019/10/31
 */
public class FactoryTest {

    public static void main (String[] args){
        Factory factory = new YiliFactory();
        System.out.println(factory.getMilk().getName());
    }


}
