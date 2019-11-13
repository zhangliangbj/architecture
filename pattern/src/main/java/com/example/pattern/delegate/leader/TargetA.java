package com.example.pattern.delegate.leader;

/**
 * @author zhangliang
 * @date 2019/11/13 17:51
 */
public class TargetA implements ITarget {
    @Override
    public void doing(String command) {
        System.out.println("我是员工A，我现在开始干" + command + "工作");
    }
}
