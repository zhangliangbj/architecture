package com.example.pattern.factory;

import com.example.pattern.Milk;
import com.example.pattern.Yili;

/**
 * @author zhangliang
 * @date 2019/10/31
 */
public class YiliFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
