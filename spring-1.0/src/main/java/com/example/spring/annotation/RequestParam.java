package com.example.spring.annotation;

import java.lang.annotation.*;

/**
 * @author zhangliang
 * @date 2019/11/25 10:16
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam {

    String value() default  "";
}
