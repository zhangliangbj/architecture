package com.example.pattern.strategy.pay;

import com.example.pattern.strategy.pay.payport.PayType;

/**
 * @author zhangliang
 * @date 2019/11/12 15:20
 */
public class Order {

    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid,String orderId,double amount){
        this.amount = amount;
        this.uid = uid;
        this.orderId = orderId;
    }

    public PayState pay(PayType payType){
        return payType.get().pay(this.uid,this.amount);
    }



}
