package com.example.spring.framework.core;

/**
 * @author zhangliang
 * @date 2019/11/25 15:25
 */
public interface BeanFactory {

    /**
     * 根据beanName从IOC容器中获得一个实例bean
     * @param name
     * @return
     */
    public Object getBean(String name);

}
