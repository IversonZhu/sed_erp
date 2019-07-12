package com.iverson.erp.provider;

import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

public class OrderMasterSqlProvider {

    public String getListSql(@Param("orderNo") String orderNo, @Param("machineNo") String machineNo, @Param("orderStatus") Integer orderStatus, @Param("payStatus") Integer payStatus){
        StringBuffer sql = new StringBuffer("select * from sed_market_order_master where 1=1");
        if(!StringUtils.isEmpty(orderNo)){
            sql.append(" and order_no like like CONCAT('%',#{orderNo},'%')");
        }
        if(!StringUtils.isEmpty(machineNo)){
            sql.append(" and machine_no like like CONCAT('%',#{machineNo},'%')");
        }
        if(orderStatus != null){
            sql.append( "and order_status=#{orderStatus}");
        }
        if(payStatus != null){
            sql.append( "and pay_status=#{payStatus}");
        }
        return sql.toString();
    }
}
