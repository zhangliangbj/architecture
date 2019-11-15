package com.example.pattern.observer.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliang
 * @date 2019/11/15 16:26
 */
public class EventListener {

    //map相当于注册器
    protected Map<Enum,Event> events = new HashMap<>();

    public void addLisenter(Enum eventType, Object target, Method callback){
        //注册事件
        //用反射调用这个方法
        events.put(eventType,new Event(target,callback));
    }

    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {
            event.getCallBack().invoke(event.getTarget(),event);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return;
    }


    protected void trigger(Enum call){
        if (!this.events.containsKey(call)){
            return;
        }
        trigger(this.events.get(call));
    }




}
