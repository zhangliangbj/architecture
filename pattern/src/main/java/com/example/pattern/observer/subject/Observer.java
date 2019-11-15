package com.example.pattern.observer.subject;

import com.example.pattern.observer.core.Event;

/**
 * @author zhangliang
 * @date 2019/11/15 16:51
 */
public class Observer {

    public void advice(Event e){
        System.out.println("=========触发事件，打印日志========\n" + e);

        /*
         *  input
         *  input.addLisenter("click",function(){
         *
         *
         *  });
         *
         *
         * */
    }

}
