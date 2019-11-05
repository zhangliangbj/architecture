package com.example.pattern.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * @author zhangliang
 * @date 2019/11/5
 */
public class QiTianDaShen extends Monkey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaShen(){
        this.birthDay = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object deepClone(){
        try {
            ByteArrayOutputStream  baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            QiTianDaShen copy = (QiTianDaShen) ois.readObject();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
