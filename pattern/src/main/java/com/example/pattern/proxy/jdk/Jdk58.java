package com.example.pattern.proxy.jdk;

import com.example.pattern.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class Jdk58 implements InvocationHandler {

    //被代理对象，保存着
    private Person target;



    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是租房中介：我要给你找房，现在已经拿到你的需求");
        System.out.println("开始物色");
        method.invoke(this.target,args);
        System.out.println("如果觉得合适，那么就签约");
        return null;
    }
}
