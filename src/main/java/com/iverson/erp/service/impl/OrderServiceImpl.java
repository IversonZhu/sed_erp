package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.converter.OrderMaster2OrderDtoConverter;
import com.iverson.erp.dto.OrderDTO;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.exception.MarketException;
import com.iverson.erp.mapper.OrderDetailMapper;
import com.iverson.erp.mapper.OrderMasterMapper;
import com.iverson.erp.pojo.OrderDetail;
import com.iverson.erp.pojo.OrderMaster;
import com.iverson.erp.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDTO findOne(String orderNo) {
        OrderMaster orderMaster = orderMasterMapper.findOne(orderNo);
        if(orderMaster == null){
            throw new MarketException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetails = orderDetailMapper.findByOrderNo(orderNo);
        if(CollectionUtils.isEmpty(orderDetails)){
            throw new MarketException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetails(orderDetails);
        return orderDTO;
    }

    @Override
    public PageInfo<OrderDTO> getList(String orderNo, String machineNo, Integer orderStatus, Integer payStatus,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderMaster> orderMasters = orderMasterMapper.getList(orderNo,machineNo,orderStatus,payStatus);
        List<OrderDTO> orderDtos = OrderMaster2OrderDtoConverter.convert(orderMasters);
        PageInfo<OrderDTO> orderDtoPageInfo = new PageInfo<>(orderDtos);
        return orderDtoPageInfo;
    }
}
