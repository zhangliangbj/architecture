package com.example.pattern.strategy.pay;

/**
 * @author zhangliang
 * @date 2019/11/12 15:26
 */
public class PayState {

    private int code;
    private Object data;
    private double msg;

    public PayState (int code,Object data,double msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String toString(){
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }


}
