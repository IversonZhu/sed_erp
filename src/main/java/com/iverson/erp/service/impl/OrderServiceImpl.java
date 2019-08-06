package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.converter.OrderMaster2OrderDtoConverter;
import com.iverson.erp.dto.CartDTO;
import com.iverson.erp.dto.OrderDTO;
import com.iverson.erp.enums.OrderStatusEnum;
import com.iverson.erp.enums.PayStatusEnum;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.exception.MarketException;
import com.iverson.erp.mapper.OrderDetailMapper;
import com.iverson.erp.mapper.OrderMasterMapper;
import com.iverson.erp.pojo.OrderDetail;
import com.iverson.erp.pojo.OrderMaster;
import com.iverson.erp.service.GoodsService;
import com.iverson.erp.service.OrderService;
import com.iverson.erp.util.NoGenerateUtil;
import com.iverson.erp.vo.GoodsVO;
import com.iverson.erp.vo.OrderMasterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private GoodsService goodsService;

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
        List<OrderMasterVO> orderMasterVOS = orderMasterMapper.getList(orderNo,machineNo,orderStatus,payStatus);
        List<OrderDTO> orderDtos = new ArrayList<>();
        for (OrderMasterVO OrderMasterVO : orderMasterVOS){
            List<OrderDetail> orderDetails = orderDetailMapper.getListByOrderNo(OrderMasterVO.getOrderNo());
            OrderDTO orderDTO = OrderMaster2OrderDtoConverter.convert(OrderMasterVO,orderDetails);
            orderDtos.add(orderDTO);
        }
        PageInfo<OrderDTO> orderDtoPageInfo = new PageInfo<>(orderDtos);
        return orderDtoPageInfo;
    }

    @Override
    @Transactional
    public OrderDTO createOrder(List<CartDTO> cartDTOS, String machineNo) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String orderNo = NoGenerateUtil.getOrderNo();
        double orderAmount = 0;
        for(CartDTO cartDTO : cartDTOS){
            GoodsVO goodsVO = goodsService.getGoodsByBarcode(cartDTO.getBarcode());
            if(goodsVO == null){
                throw new MarketException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算总价
            orderAmount += goodsVO.getPrice() * cartDTO.getQuantity();

            //订单详情写入
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderDetailNo(NoGenerateUtil.getOrderDetailNO());
            orderDetail.setOrderNo(orderNo);
            orderDetail.setGoodsBarcode(goodsVO.getBarcode());
            orderDetail.setGoodsName(goodsVO.getName());
            orderDetail.setGoodsNo(goodsVO.getGoodsNo());
            orderDetail.setGoodsPrice(goodsVO.getPrice());
            orderDetail.setGoodsWeight(goodsVO.getWeight());
            orderDetail.setGoodsQuantity(cartDTO.getQuantity());
            orderDetails.add(orderDetail);
            orderDetailMapper.addOne(orderDetail);
        }
        //订单写入
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderNo(orderNo);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setMachineNo(machineNo);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW_ORDER.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.addOne(orderMaster);

        //构建orderDTO
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderDetails(orderDetails);
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
}
