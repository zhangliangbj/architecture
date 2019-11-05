package com.example.pattern.model.enums;

/**
 * @author zhangliang
 * @date 2019/10/30
 */
public enum MilkEnum {

    TENLUNSU("特仑苏"),

    MENGNIU("蒙牛"),

    YILI("伊利"),

    ;

    private String desc;

    MilkEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
