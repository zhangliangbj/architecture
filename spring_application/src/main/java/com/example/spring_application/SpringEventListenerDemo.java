package com.example.spring_application;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author zhangliang
 * @date 2019/11/18 17:24
 */
public class SpringEventListenerDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        //添加事件监听器
//        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
//            @Override
//            public void onApplicationEvent(ApplicationEvent event) {
//                System.err.println("监听事件："+event);
//            }
//        });

        //添加自定义监听器
        context.addApplicationListener(new ClosedListener());

        //启动spring应用上下文
        context.refresh();

        //两个事件，一个是ContextRefreshedEvent，一个是PayloadApplicationEvent
        //Spring应用上下文发布时间
        context.publishEvent("HelloWorld");//发布一个HelloWorld内容的事件
        //一个是我自己的是事件
        context.publishEvent(new MyEvent("HelloWorld 2019"));

        //关闭应用上下文
        context.close();
    }

    private static class ClosedListener implements ApplicationListener<ContextClosedEvent>{

        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            System.out.println("关闭上下文时间"+event);
        }
    }

    private static class MyEvent extends ApplicationEvent{


        public MyEvent(Object source) {
            super(source);
        }
    }

}
//监听事件：org.springframework.context.event.ContextRefreshedEvent[source=org.springframework.context.support.GenericApplicationContext@6e8dacdf, started on Mon Nov 18 17:37:38 CST 2019]
//监听事件：org.springframework.context.PayloadApplicationEvent[source=org.springframework.context.support.GenericApplicationContext@6e8dacdf, started on Mon Nov 18 17:37:38 CST 2019]
