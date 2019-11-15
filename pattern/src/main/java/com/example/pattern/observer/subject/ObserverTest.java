package com.example.pattern.observer.subject;

import com.example.pattern.observer.core.Event;

import java.lang.reflect.Method;

/**
 * @author zhangliang
 * @date 2019/11/15 16:53
 */
public class ObserverTest {


    public static void main(String[] args) {

        try{

            //观察者
            Observer observer = new Observer();
            Method advice = Observer.class.getMethod("advice", new Class<?>[]{Event.class});


            //这里写被观察者
            Subject subject = new Subject();
            subject.addLisenter(SubjectTypeEnum.ON_ADD,observer,advice);
            subject.addLisenter(SubjectTypeEnum.ON_EDIT,observer,advice);
            subject.addLisenter(SubjectTypeEnum.ON_RMOVE,observer,advice);
            subject.addLisenter(SubjectTypeEnum.ON_QUERY,observer,advice);

            subject.add();
            subject.remove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
