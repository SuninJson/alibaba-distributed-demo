package com.sen.spring.demo.order.processor;

import com.google.common.collect.Maps;
import com.sen.spring.demo.constant.OrderType;
import com.sen.spring.demo.order.annotation.SpecificOrderHandler;
import com.sen.spring.demo.order.context.OrderHandlerContext;
import com.sen.spring.demo.order.context.handler.OrderHandler;
import com.sen.spring.demo.util.ClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author Huang Sen
 */
@Component
public class OrderHandlerFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        HashMap<OrderType, Class<? extends OrderHandler>> handlerMapping = Maps.newHashMapWithExpectedSize(3);

        ClassScanner.getAllClassByInterface(OrderHandler.class).forEach(handlerClass -> {
            OrderType orderType = handlerClass.getAnnotation(SpecificOrderHandler.class).value();
            handlerMapping.put(orderType, handlerClass);
        });

        //初始化OrderHandlerContext，将其注册到Spring容器中
        OrderHandlerContext context = new OrderHandlerContext(handlerMapping);
        beanFactory.registerSingleton(context.getClass().getName(), context);
    }
}
