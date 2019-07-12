package com.iverson.sed_erp.dto;

import com.iverson.sed_erp.pojo.OrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private String orderNo;
    private String machineNo;
    private Double orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    List<OrderDetail> orderDetails;
}
