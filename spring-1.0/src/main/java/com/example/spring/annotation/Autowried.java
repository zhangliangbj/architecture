package com.example.spring.annotation;

import java.lang.annotation.*;

/**
 * @author zhangliang
 * @date 2019/11/25 10:15
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowried {
    String value() default  "";
}
