package com.example.pattern.proxy.cglib;

/**
 * @author zhangliang
 * @date 2019/11/6
 */
public class CglibTest {

    public static void main(String[] args) {
        try{
            ZhangSan zhangSan = (ZhangSan)new CglibMeipo().getInstance(ZhangSan.class);
            zhangSan.findLove();
        }catch (Exception e){

        }
    }



}
