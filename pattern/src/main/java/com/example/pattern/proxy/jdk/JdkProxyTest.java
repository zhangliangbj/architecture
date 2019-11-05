package com.example.pattern.proxy.jdk;

import com.example.pattern.proxy.staticed.Person;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        try{
            //静态代理会是直接构造JdkMeipo的对象,就像下面这样
            //JdkMeipo jdkMeipo = new JdkMeipo(new Person());
//            Person person = (Person) new JdkMeipo().getInstance(new ZhangSan());
//            person.findLove();

            Person person1 = (Person) new Jdk58().getInstance(new ZhangSan());
            person1.zhuFang();
        }catch (Exception e){
            System.out.println("捕获到错误了");
        }

    }

}
