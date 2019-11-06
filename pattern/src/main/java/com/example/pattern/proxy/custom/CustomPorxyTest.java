package com.example.pattern.proxy.custom;


import com.example.pattern.proxy.jdk.ZhangSan;
import com.example.pattern.proxy.staticed.Person;

import java.io.FileOutputStream;

/**
 * Created by Tom on 2018/3/10.
 */
public class CustomPorxyTest {

    public static void main(String[] args) {

        try {
            Person obj = (Person)new CustomMeipo().getInstance(new ZhangSan());
            System.out.println(obj.getClass());
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
