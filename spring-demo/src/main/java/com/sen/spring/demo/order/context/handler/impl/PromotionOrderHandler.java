package com.sen.spring.demo.order.context.handler.impl;

import com.sen.spring.demo.constant.OrderType;
import com.sen.spring.demo.order.annotation.SpecificOrderHandler;
import com.sen.spring.demo.order.context.handler.AbstractOrderHandler;
import com.sen.spring.demo.order.context.handler.OrderHandler;
import org.springframework.stereotype.Component;

/**
 * @author Huang Sen
 */
@Component
@SpecificOrderHandler(OrderType.PROMOTION)
public class PromotionOrderHandler extends AbstractOrderHandler implements OrderHandler {
}
