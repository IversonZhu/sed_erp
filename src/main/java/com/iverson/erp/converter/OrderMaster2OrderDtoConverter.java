package com.iverson.erp.converter;

import com.iverson.erp.dto.OrderDTO;
import com.iverson.erp.pojo.OrderDetail;
import com.iverson.erp.pojo.OrderMaster;
import com.iverson.erp.vo.OrderMasterVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * orderMaster --> orderDTO 装换类
 * @author Iverson
 * @date 2019/07/13
 */
public class OrderMaster2OrderDtoConverter {
    public static OrderDTO convert(OrderMasterVO orderMasterVO, List<OrderDetail> orderDetails) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMasterVO, orderDTO);
        orderDTO.setOrderDetails(orderDetails);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMasterVO> orderMasterVOS, List<OrderDetail> orderDetails) {
        return orderMasterVOS.stream().map(e ->
                convert(e,orderDetails)
        ).collect(Collectors.toList());
    }
}
