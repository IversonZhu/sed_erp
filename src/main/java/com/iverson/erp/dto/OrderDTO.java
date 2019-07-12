package com.iverson.erp.dto;

import com.iverson.erp.pojo.OrderDetail;
import lombok.Data;

import java.util.List;

/**
 * class orderDTO
 * @author Iverson
 * @date 2019/07/13
 */

@Data
public class OrderDTO {
    private String orderNo;
    private String machineNo;
    private Double orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    List<OrderDetail> orderDetails;
}
