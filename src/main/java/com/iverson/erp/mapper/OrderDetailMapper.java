package com.iverson.erp.mapper;

import com.iverson.erp.pojo.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderDetailMapper {


    @Select("select * from sed_market_order_detail where order_no=#{orderNo}")
    List<OrderDetail> findByOrderNo(String orderNo);

    @Insert("insert into sed_market_order_detail(order_detail_no,order_no,goods_no,goods_name,goods_barcode,goods_price,goods_weight,goods_quantity) " +
            "values(#{orderDetailNo},#{orderNo},#{goodsNo},#{goodsName},#{goodsBarcode},#{goodsPrice},#{goodsWeight},#{goodsQuantity})")
    int addOne(OrderDetail orderDetail);

    @Select("select * from sed_market_order_detail where order_no=#{orderNo}")
    List<OrderDetail> getListByOrderNo(String orderNo);
}
