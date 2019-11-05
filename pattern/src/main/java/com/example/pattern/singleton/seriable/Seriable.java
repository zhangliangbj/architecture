package com.example.pattern.singleton.seriable;

import java.io.Serializable;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class Seriable implements Serializable {

    private static final Seriable Instance = new Seriable();

    private Seriable(){}

    public static Seriable getInstance(){
        return Instance;
    }

    private Object readResolve(){
        return Instance;
    }
}
