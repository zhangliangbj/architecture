package com.example.pattern.singleton;

/**
 * @author zhangliang
 * @date 2019/11/4
 */
public class Hungry {

    //优点：没有加任何的锁、执行效率比较高
    //在用户体验上来说，比懒汉式更好

    //缺点：类加载的时候就初始化，不管用还是没用，都占用着空间

    //绝对线程安全，在线程还没出现以前就是实例化了，不存在访问安全问题

    private Hungry(){}

    private static final Hungry single = new Hungry();

    public static Hungry getInstance(){
        return new Hungry();
    }

}
