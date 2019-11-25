package com.example.spring.framework.beans;

import com.example.spring.framework.core.FactoryBean;

/**
 * @author zhangliang
 * @date 2019/11/25 15:47
 */
public class BeanWrapper extends FactoryBean {

    public BeanPostProcessor getBeanPostProcessor() {
        return beanPostProcessor;
    }

    public void setBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessor = beanPostProcessor;
    }

    //还会用到  观察者模式
    //1、支持事件响应，会有一个监听
    private BeanPostProcessor beanPostProcessor;

    private  Object wrapperInstance;
    //原始的通过反射new出来的，要包装起来，存下来
    private Object originalInstance;

    public BeanWrapper(Object instance){
        this.wrapperInstance = instance;
        this.originalInstance = instance;
    }

    public Object getWrappedInstance(){
        return this.wrapperInstance;
    }

    //返回代理以后的class
    //可能会是这个$proxy0
    public Class<?> getWrappedClass(){
        return this.wrapperInstance.getClass();
    }



}
