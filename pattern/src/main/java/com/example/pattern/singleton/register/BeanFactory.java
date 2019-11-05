package com.example.pattern.singleton.register;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class BeanFactory {

    private BeanFactory(){};

    private static final Map ioc = new ConcurrentHashMap();

    public static BeanFactory getBean(String name) throws Exception{
        if (!ioc.containsKey(name)){
            Object obj = null;
            obj = Class.forName(name).newInstance();
            ioc.put(name,obj);
        }
        return (BeanFactory) ioc.get(name);
    }






}
