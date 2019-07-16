package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.dto.CartDTO;
import com.iverson.erp.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO findOne(String orderNo);

    PageInfo<OrderDTO> getList(String orderNo, String machineNo, Integer orderStatus, Integer payStatus,int pageNum,int pageSize);

    OrderDTO createOrder(List<CartDTO> cartDTOS, String machineNo);
}
