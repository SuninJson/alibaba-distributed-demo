package com.sen.spring.demo.order.annotation;

import com.sen.spring.demo.constant.OrderType;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SpecificOrderHandler {
    OrderType value();
}
