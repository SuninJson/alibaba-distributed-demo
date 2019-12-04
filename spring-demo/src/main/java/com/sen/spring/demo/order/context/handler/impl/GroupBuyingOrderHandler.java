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
@SpecificOrderHandler(OrderType.GROUP_BUYING)
public class GroupBuyingOrderHandler extends AbstractOrderHandler implements OrderHandler {
}
