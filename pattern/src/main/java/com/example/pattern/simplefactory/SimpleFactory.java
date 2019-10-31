package com.example.pattern.simplefactory.impl;

import com.example.pattern.Mengniu;
import com.example.pattern.Milk;
import com.example.pattern.Telunsu;
import com.example.pattern.Yili;
import com.example.pattern.model.enums.MilkEnum;
import org.apache.commons.lang.StringUtils;

/**
 * @author zhangliang
 * @date 2019/10/30
 */
public class SimpleFactory {

    public Milk getMilk(String name){
        if (StringUtils.equals(name, MilkEnum.MENGNIU.getDesc())){
            return new Mengniu();
        }else if (StringUtils.equals(name, MilkEnum.TENLUNSU.getDesc())){
            return new Telunsu();
        }else if (StringUtils.equals(name, MilkEnum.YILI.getDesc())) {
            return new Yili();
        }else {
            System.out.println("不能生成你需要的产品");
            return null;
        }
    }
}
