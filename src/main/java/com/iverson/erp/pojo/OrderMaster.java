package com.iverson.erp.pojo;

import lombok.Data;

@Data
public class OrderMaster {
    /** id */
    private int id;
    /** 订单编号 */
    private String orderNo;
    /** 员工编号 */
    private String staffNo;
    /** 订单编号 */
    private String shopNo;
    /** 机器编号 */
    private String machineNo;
    /** 订单总金额 */
    private Double orderAmount;
    /** 订单状态 */
    private Integer orderStatus;
    /** 支付状态 */
    private Integer payStatus;
}
