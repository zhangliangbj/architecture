package com.example.pattern.singleton.lazy;

/**
 * @author zhangliang
 * @date 2019/11/4
 */
public class LazyOne {

    //在外部需要使用的时候才进行实例化
    private LazyOne(){}

    //静态块，公共内存区域
    private static LazyOne lazyOne = null;

    public static LazyOne getInstance(){

        //先判断，是否实例化
        if (lazyOne == null){
            lazyOne = new LazyOne();
        }

        return lazyOne;
    }

}
