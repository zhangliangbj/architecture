package com.example.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @author zhangliang
 * @date 2019/11/24 22:02
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {

    String value() default "";

}
