package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.OrderMaster;
import com.iverson.sed_erp.provider.OrderMasterSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderMasterMapper {

    @Select("select * from sed_market_order_master where order_no=#{orderNo}")
    OrderMaster findOne(String orderNo);

    @SelectProvider(type = OrderMasterSqlProvider.class, method = "getListSql")
    List<OrderMaster> getList(String orderNo, String machineNo, Integer orderStatus, Integer payStatus);
}
