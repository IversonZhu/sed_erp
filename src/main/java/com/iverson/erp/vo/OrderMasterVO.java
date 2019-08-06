package com.iverson.erp.vo;

import lombok.Data;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/8/6
 */
@Data
public class OrderMasterVO {
    /** 订单编号 */
    private String orderNo;
    /** 员工编号 */
    private String staffNo;
    /** 员工姓名 */
    private String name;
    /** 商店编号 */
    private String shopNo;
    /** 商店名称 */
    private String shopName;
    /** 机器编号 */
    private String machineNo;
    /** 机器名称 */
    private String machineName;
    /** 订单总价 */
    private Double orderAmount;
    /** 订单状态 */
    private Integer orderStatus;
    /** 支付状态 */
    private Integer payStatus;
}
