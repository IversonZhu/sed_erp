package com.iverson.erp.mapper;

import com.iverson.erp.pojo.OrderMaster;
import com.iverson.erp.provider.OrderMasterSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderMasterMapper {

    @Select("select * from sed_market_order_master where order_no=#{orderNo}")
    OrderMaster findOne(String orderNo);

    @SelectProvider(type = OrderMasterSqlProvider.class, method = "getListSql")
    List<OrderMaster> getList(@Param("orderNo") String orderNo,
                              @Param("machineNo") String machineNo,
                              @Param("orderStatus") Integer orderStatus,
                              @Param("payStatus")Integer payStatus);

    @Insert("insert into sed_market_order_master (order_no,machine_no,order_amount,order_status,pay_status) values(#{orderNo},#{machineNo},#{orderAmount},#{orderStatus},#{payStatus})")
    void addOne(OrderMaster orderMaster);
}
