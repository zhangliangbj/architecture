package com.example.pattern.prototype.simple;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class Prototype implements Cloneable {

    private String name;

    private CloneTarget cloneTarget = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CloneTarget getCloneTarget() {
        return cloneTarget;
    }

    public void setCloneTarget(CloneTarget cloneTarget) {
        this.cloneTarget = cloneTarget;
    }
}
