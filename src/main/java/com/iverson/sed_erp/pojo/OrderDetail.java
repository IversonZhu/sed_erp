package com.iverson.sed_erp.pojo;

import lombok.Data;

@Data
public class OrderDetail {
    /** id */
    private int id;
    /** 订单详情编号 */
    private String OrderDetailNo;
    /** 订单编号 */
    private String orderNo;
    /** 商品编号 */
    private String goodsNo;
    /** 商品名称 */
    private String goodsName;
    /** 商品条码 */
    private String goodsBarcode;
    /** 商品价格 */
    private Double goodsPrice;
    /** 商品重量 */
    private Double goodsWeight;
    /** 商品数量 */
    private Integer goodsQuantity;
}
