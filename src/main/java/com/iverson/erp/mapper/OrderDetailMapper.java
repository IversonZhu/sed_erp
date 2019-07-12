package com.iverson.erp.mapper;

import com.iverson.erp.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderDetailMapper {

    @Select("select * from sed_market_order_detail where order_no=#{orderNo}")
    List<OrderDetail> findByOrderNo(String orderNo);
}
