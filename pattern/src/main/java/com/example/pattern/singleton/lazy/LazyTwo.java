package com.example.pattern.singleton.lazy;

/**
 * @author zhangliang
 * @date 2019/11/4
 */
public class LazyTwo {

    private LazyTwo(){}

    private static LazyTwo lazyTwo = null;

//    public static LazyTwo getInstance(){
//
//        if (lazyTwo == null){
//            synchronized (LazyTwo.class){
//                lazyTwo = new LazyTwo();
//            }
//        }
//        return lazyTwo;
//    }
    public static synchronized LazyTwo getInstance(){

        if (lazyTwo == null){
                lazyTwo = new LazyTwo();
        }
        return lazyTwo;
    }
}
