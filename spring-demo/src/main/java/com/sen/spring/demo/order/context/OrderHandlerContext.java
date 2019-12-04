package com.sen.spring.demo.order.context;

import com.sen.spring.demo.constant.OrderType;
import com.sen.spring.demo.order.context.handler.OrderHandler;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Huang Sen
 */
public class OrderHandlerContext {

    private Map<OrderType, Class<? extends OrderHandler>> handlerMapping;

    public OrderHandlerContext(Map<OrderType, Class<? extends OrderHandler>> handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    public OrderHandler getHandler(OrderType type) {
        String typeName = type.getClass().getSimpleName();
        try {
            Class<? extends OrderHandler> handlerClass = handlerMapping.get(type);
            if (handlerClass == null) {
                throw new IllegalArgumentException("Not found order-handler for type:"
                        + typeName);
            }
            return ReflectionUtils.accessibleConstructor(handlerClass).newInstance();
        } catch (Throwable ex) {
            throw new IllegalArgumentException("Unable to instantiate order-handler class: " + typeName, ex);
        }
    }
}
