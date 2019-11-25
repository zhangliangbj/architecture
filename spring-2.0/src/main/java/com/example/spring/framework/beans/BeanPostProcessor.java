package com.example.spring.framework.beans;

/**
 * @author zhangliang
 * @date 2019/11/25 20:27
 */
//用于做事件监听的
public class BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean,String beanName){
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean,String beanName){
        return bean;
    }

}
