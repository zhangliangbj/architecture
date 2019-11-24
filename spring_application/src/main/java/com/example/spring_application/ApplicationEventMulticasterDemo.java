package com.example.spring_application;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * @author zhangliang
 * @date 2019/11/19 10:20
 */
public class ApplicationEventMulticasterDemo {

    public static void main(String[] args) {
        ApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.addApplicationListener(event -> {
            if (event instanceof PayloadApplicationEvent){
                System.out.println("接收到PayloadApplicationEvent："
                + PayloadApplicationEvent.class.cast(event).getPayload());
            }
            System.out.println("接收到事件："+event);
        });
        //发布/广播事件
        multicaster.multicastEvent(new PayloadApplicationEvent<Object>("","Hello World"));
    }

}
