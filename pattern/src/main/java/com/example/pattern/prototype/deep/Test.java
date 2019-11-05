package com.example.pattern.prototype.deep;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class Test {

    public static void main(String[] args) {
        QiTianDaShen q = new QiTianDaShen();
        try {
            QiTianDaShen qiTianDaShen = (QiTianDaShen) q.clone();
            System.out.println(q.jinGuBang);
            System.out.println(qiTianDaShen.jinGuBang);
            System.out.println(qiTianDaShen.getBirthDay());
            System.out.println(q.getBirthDay());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

//深度拷贝使用序列化对大圣的金箍棒对象进行序列化操作，他们不是同一个对象了，
// 这就是通过序列化实现的深度拷贝，提现了原型模式
}
