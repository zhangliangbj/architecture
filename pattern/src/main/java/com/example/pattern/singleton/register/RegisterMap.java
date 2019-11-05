package com.example.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangliang
 * @date 2019/11/5
 */

//注册式单例
public class RegisterMap {

    private static final Map registerMap = new ConcurrentHashMap();

    private RegisterMap(){}

    public static RegisterMap getInstance(String name){
        if (name == null){
            name = RegisterMap.class.getName();
        }

        if (registerMap.get(name) == null){
            registerMap.put(name,new RegisterMap());
        }
        return (RegisterMap)registerMap.get(name);
    }





}
