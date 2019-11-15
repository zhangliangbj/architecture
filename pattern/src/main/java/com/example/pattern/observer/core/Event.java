package com.example.pattern.observer.core;

import java.lang.reflect.Method;

/**
 * @author zhangliang
 * @date 2019/11/15 16:23
 */
public class Event {
    //事件源
    private Object source;
    //通知目标
    private Object target;
    //回调
    private Method callBack;
    //触发
    private String trigger;
    private long time;


    public Event(Object target, Method callBack) {
        this.target = target;
        this.callBack = callBack;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallBack() {
        return callBack;
    }

    public void setCallBack(Method callBack) {
        this.callBack = callBack;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
