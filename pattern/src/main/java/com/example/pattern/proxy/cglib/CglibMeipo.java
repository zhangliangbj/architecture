package com.example.pattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangliang
 * @date 2019/11/6
 */
public class CglibMeipo implements MethodInterceptor {


    public Object getInstance(Class<?> clazz) throws Exception {
            Enhancer enhancer = new Enhancer();
            //要把clazz设置为即将生成的新类父类
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(this);

            return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是媒婆：我要给你找对象，已经拿到你的需求");
        System.out.println("开始物色");
        methodProxy.invokeSuper(o,objects);
        System.out.println("如果合适的话，准备办事");
        return null;
    }
}
