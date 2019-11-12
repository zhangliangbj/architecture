package com.example.pattern.strategy.pay.payport;


import com.example.pattern.strategy.pay.PayState;

/**
 * @author zhangliang
 * @date 2019/11/12 15:20
 */
public interface Payment {

    public PayState pay(String uid, double amount);

}
