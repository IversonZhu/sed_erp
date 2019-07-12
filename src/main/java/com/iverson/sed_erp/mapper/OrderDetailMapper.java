package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.OrderDetail;
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
