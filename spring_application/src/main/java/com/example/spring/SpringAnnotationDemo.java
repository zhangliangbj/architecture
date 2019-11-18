package com.example.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangliang
 * @date 2019/11/18 11:56
 */
@Configuration
public class SpringAnnotationDemo {

    public static void main(String[] args) {
        // XML配置文件驱动    ClassPathXmlApplicationContext
        //Annotation驱动       （两者都是找BeanDefinition）
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
        //注册一个Configuration class = SpringAnnotationDemo
        context.register(SpringAnnotationDemo.class);
        //上下文启动
        context.refresh();
        System.out.println(context.getBean(SpringAnnotationDemo.class));
    }
}
