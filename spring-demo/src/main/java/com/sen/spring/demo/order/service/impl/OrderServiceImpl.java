package com.sen.spring.demo.order.service.impl;

import com.sen.spring.demo.order.context.OrderHandlerContext;
import com.sen.spring.demo.order.context.handler.OrderHandler;
import com.sen.spring.demo.order.dto.OrderDTO;
import com.sen.spring.demo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Huang Sen
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderHandlerContext handlerContext;

    @Autowired
    public OrderServiceImpl(OrderHandlerContext handlerContext) {
        this.handlerContext = handlerContext;
    }

    @Override
    public String handle(OrderDTO dto) {
        OrderHandler handler = handlerContext.getHandler(dto.getType());
        return handler.doHandle(dto);
    }
}
