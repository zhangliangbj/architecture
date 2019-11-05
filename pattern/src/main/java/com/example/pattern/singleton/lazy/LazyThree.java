package com.example.pattern.singleton.lazy;

/**
 * @author zhangliang
 * @date 2019/11/4
 */
    /*
    *
    * //懒汉式单例
//特点：在外部类被调用的时候内部类才会被加载
//内部类一定是要在方法调用之前初始化
//巧妙地避免了线程安全问题

//这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
//完美地屏蔽了这两个缺点
//史上最牛B的单例模式的实现方式
    *
    * */
public class LazyThree {

    private boolean initialized = false;

    private LazyThree(){
            if (initialized == false){
                initialized = true;
            }else {

            }
    }

    //static 是为了使单例的空间共享
    //保证这个方法不会被重写，重载
    public static LazyThree getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyThree LAZY = new LazyThree();
    }

}

/*
*有点饿汉式的感觉，当调用外部内，内部内才被加载，外部类才能被初始化，饿汉式是类加载的时候初始化了
* */
