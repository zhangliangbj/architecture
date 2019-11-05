package com.example.pattern.proxy.jdk;

import com.example.pattern.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class JdkMeipo implements InvocationHandler {
    //把被代理的对象保存下来
    private Person target;

    public Object getInstance(Person target) throws Exception{
        this.target = target;
//        Class clazz = Class.forName(this.target.getClass().getName());
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
        //loader:Proxy.newProxyInstance的三个参数分别代表什么
        //interfaces:用哪个类加载器去加载类对象
        //h:动态代理方法执行时，会调用h里面的invoke方法去执行
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：我要给你找对象，现在已经拿到你的需求");
        System.out.println("开始物色");

        method.invoke(this.target,args);

        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
