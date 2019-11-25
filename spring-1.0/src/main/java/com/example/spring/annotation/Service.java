package com.example.spring.annotation;

import java.lang.annotation.*;

/**
 * @author zhangliang
 * @date 2019/11/25 10:16
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {

    String value() default  "";
}
