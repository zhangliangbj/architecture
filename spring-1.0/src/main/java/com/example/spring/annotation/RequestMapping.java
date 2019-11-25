package com.example.spring.annotation;

import java.lang.annotation.*;

/**
 * @author zhangliang
 * @date 2019/11/25 10:14
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {

    String value() default  "";
}
