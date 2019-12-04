package com.sen.spring.demo.order.service;

import com.sen.spring.demo.order.dto.OrderDTO;

/**
 * @author Huang Sen
 */
public interface OrderService {

    /**
     * 根据订单的不同类型进行不同的处理
     * @param dto 订单的传输对象
     * @return 简单起见，暂时将处理结果作为字符串返回
     */
    String handle(OrderDTO dto);
}
