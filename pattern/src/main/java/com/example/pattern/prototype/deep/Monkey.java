package com.example.pattern.prototype.deep;

import java.util.Date;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class Monkey {

    public Date birthDay;

    private int height;

    private int weight;

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
