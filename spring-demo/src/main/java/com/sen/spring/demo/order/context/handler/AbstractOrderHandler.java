package com.sen.spring.demo.order.context.handler;

import com.sen.spring.demo.order.dto.OrderDTO;

/**
 * @author Huang Sen
 */
public abstract class AbstractOrderHandler implements OrderHandler {

    @Override
    public String doHandle(OrderDTO dto) {
        return "处理" + dto.getType().getClass().getSimpleName() + "类型的订单";
    }
}
