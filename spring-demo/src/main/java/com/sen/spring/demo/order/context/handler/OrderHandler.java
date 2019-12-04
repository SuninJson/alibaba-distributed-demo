package com.sen.spring.demo.order.context.handler;

import com.sen.spring.demo.order.dto.OrderDTO;

/**
 * @author Huang Sen
 */
public interface OrderHandler {

    String doHandle(OrderDTO dto);
}
