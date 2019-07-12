package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.dto.OrderDTO;

public interface OrderService {
    OrderDTO findOne(String orderNo);

    PageInfo<OrderDTO> getList(String orderNo, String machineNo, Integer orderStatus, Integer payStatus,int pageNum,int pageSize);
}
