package com.example.pattern.prototype.simple;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class CloneTest {

    public static void main(String[] args) {
        CloneTarget p = new CloneTarget();
        p.setName("hehe");
        p.setCloneTarget(new CloneTarget());
        System.out.println(p.getCloneTarget());

        try {
            CloneTarget cloneTarget = (CloneTarget) p.clone();
            System.out.println(cloneTarget.getCloneTarget());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//p.getCloneTarget()和cloneTarget.getCloneTarget()指向的对象是同一个，这就是浅拷贝的缺点，如果一个改动了，那另一个也被改了

    }


}
