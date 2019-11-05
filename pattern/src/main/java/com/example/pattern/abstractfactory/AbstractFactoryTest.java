package com.example.pattern.abstractfactory;

import com.example.pattern.Milk;

/**
 * @author zhangliang
 * @date 2019/10/31
 */
public class AbstractFactoryTest {

    public static void main(String[] args){
        FactoryAbstract factoryAbstract = new FactoryAbstract();
        Milk milk = factoryAbstract.getMengniu();
        System.out.println(milk.getName());
    }

}
