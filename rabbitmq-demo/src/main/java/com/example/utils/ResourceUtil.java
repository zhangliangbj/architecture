package com.example.utils;

import java.util.ResourceBundle;

/**
 * @author zhangliang
 * @date 2019/12/14 14:33
 */
public class ResourceUtil {

    private static final ResourceBundle resourceBundle;

    static{
        resourceBundle = ResourceBundle.getBundle("config");
    }

    public static String getKey(String key){
        return resourceBundle.getString(key);
    }

}
