package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.dto.OrderDTO;

public interface OrderService {
    OrderDTO findOne(String orderNo);

    PageInfo<OrderDTO> getList(String orderNo, String machineNo, Integer orderStatus, Integer payStatus,int pageNum,int pageSize);
}
