package com.example.pattern.observer.subject;

import com.example.pattern.observer.core.EventListener;

/**
 * @author zhangliang
 * @date 2019/11/15 16:46
 */
public class Subject extends EventListener {

    //通常采用动态代理实现监控，避免代码侵入
    public void add(){
        System.out.println("调用添加方法");
        this.trigger(SubjectTypeEnum.ON_ADD);
    }

    public void remove(){
        System.out.println("调用删除方法");
        this.trigger(SubjectTypeEnum.ON_RMOVE);
    }





}
