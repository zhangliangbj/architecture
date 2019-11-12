package com.example.pattern.strategy.pay.payport;


import com.example.pattern.strategy.pay.PayState;

/**
 * @author zhangliang
 * @date 2019/11/12 15:20
 */
public class UnionPay implements Payment {

    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用银联卡支付");
        System.out.println("查询账户余额，开始扣款");
        return new PayState(200,"支付成功",amount);
    }
}
