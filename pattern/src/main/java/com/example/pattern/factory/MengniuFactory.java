package com.example.pattern.factory;

import com.example.pattern.Mengniu;
import com.example.pattern.Milk;

/**
 * @author zhangliang
 * @date 2019/10/31
 */
public class MengniuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
