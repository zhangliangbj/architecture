package com.example.pattern.strategy.pay;

import com.example.pattern.strategy.pay.payport.PayType;

/**
 * @author zhangliang
 * @date 2019/11/12 15:39
 */
public class PayStrategyTest {

    public static void main(String[] args) {
        Order order = new Order("1","5222000000000000000",415.00);
        order.pay(PayType.WECHAT_PAY);
    }

}
