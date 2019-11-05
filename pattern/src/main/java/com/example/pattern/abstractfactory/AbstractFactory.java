package com.example.pattern.abstractfactory;

import com.example.pattern.Milk;

/**
 * @author zhangliang
 * @date 2019/10/31
 */
public abstract class AbstractFactory {

    public abstract Milk getMengniu();

    public abstract Milk getYili();

    public abstract Milk getTelunsu();

}
