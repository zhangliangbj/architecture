package com.example.pattern.proxy.staticed;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class Father {

    public Person person;

    public Father(Person person){
        this.person = person;
    }

    public void findLove(){
        System.out.println("根据条件找");
        person.findLove();
        System.out.println("看双方父母是否同意");
    }
}
