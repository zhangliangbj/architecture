package com.example.pattern.singleton.Test;


import com.example.pattern.singleton.lazy.LazyTwo;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class LazyTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000000;i ++) {
            Object obj = LazyTwo.getInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }

}
