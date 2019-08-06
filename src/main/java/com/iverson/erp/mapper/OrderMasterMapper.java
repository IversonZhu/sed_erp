package com.iverson.erp.mapper;

import com.iverson.erp.pojo.OrderMaster;
import com.iverson.erp.vo.OrderMasterVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@Mapper
public interface OrderMasterMapper {

    @Select("select * from sed_market_order_master where order_no=#{orderNo}")
    OrderMaster findOne(String orderNo);

    @SelectProvider(type = OrderMasterSqlProvider.class, method = "getListSql")
    List<OrderMasterVO> getList(@Param("orderNo") String orderNo,
                                @Param("machineNo") String machineNo,
                                @Param("orderStatus") Integer orderStatus,
                                @Param("payStatus")Integer payStatus);

    @Insert("insert into sed_market_order_master (order_no,staff_no,shop_no,machine_no,order_amount,order_status,pay_status) values(#{orderNo},#{staffNo},#{shopNo},#{machineNo},#{orderAmount},#{orderStatus},#{payStatus})")
    void addOne(OrderMaster orderMaster);

    class OrderMasterSqlProvider {
        public String getListSql(@Param("orderNo") String orderNo, @Param("machineNo") String machineNo, @Param("orderStatus") Integer orderStatus, @Param("payStatus") Integer payStatus){
            StringBuffer sql = new StringBuffer("select m.order_no,m.staff_no,sa.name,m.shop_no,s.shop_name,m.machine_no,ma.machine_name,m.order_amount,m.order_status,m.pay_status " +
                    "from sed_market_shop s, sed_market_order_master m, sed_market_staff sa ,sed_market_machine ma " +
                    "where m.shop_no = s.shop_no and m.staff_no = sa.staff_no and m.machine_no = ma.machine_no");
            if(!StringUtils.isEmpty(orderNo)){
                sql.append(" and order_no like CONCAT('%',#{orderNo},'%')");
            }
            if(!StringUtils.isEmpty(machineNo)){
                sql.append(" and machine_no like CONCAT('%',#{machineNo},'%')");
            }
            if(orderStatus != null){
                sql.append( " and order_status=#{orderStatus}");
            }
            if(payStatus != null){
                sql.append( " and pay_status=#{payStatus}");
            }
            return sql.toString();
        }
    }
}
