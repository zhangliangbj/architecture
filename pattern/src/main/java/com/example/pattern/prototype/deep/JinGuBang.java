package com.example.pattern.prototype.deep;

import java.io.Serializable;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class JinGuBang implements Serializable {

    private int height;

    private int weight;

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
