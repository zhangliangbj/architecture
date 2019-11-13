package com.example.pattern.delegate.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliang
 * @date 2019/11/13 17:48
 */
public class Leader implements ITarget {

    private Map<String,ITarget> targets = new HashMap<String,ITarget>();

    public Leader() {
        targets.put("加密",new TargetA());
        targets.put("登录",new TargetB());
    }


    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
