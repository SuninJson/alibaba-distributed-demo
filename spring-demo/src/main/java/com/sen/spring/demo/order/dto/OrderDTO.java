package com.sen.spring.demo.order.dto;

import com.sen.spring.demo.constant.OrderType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Huang Sen
 */
@Data
public class OrderDTO {

    private String code;
    private BigDecimal price;
    private OrderType type;
}
