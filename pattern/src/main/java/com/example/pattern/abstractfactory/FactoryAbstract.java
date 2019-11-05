package com.example.pattern.abstractfactory;

import com.example.pattern.Mengniu;
import com.example.pattern.Milk;
import com.example.pattern.Telunsu;
import com.example.pattern.Yili;

/**
 * @author zhangliang
 * @date 2019/10/31
 */
public class FactoryAbstract extends AbstractFactory {
    @Override
    public Milk getMengniu() {
        return new Mengniu();
    }

    @Override
    public Milk getYili() {
        return new Yili();
    }

    @Override
    public Milk getTelunsu() {
        return new Telunsu();
    }
}
