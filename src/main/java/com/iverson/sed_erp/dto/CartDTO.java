package com.iverson.sed_erp.dto;

import lombok.Data;

/**
 * 购物车
 */
@Data
public class CartDTO {
    /** 商品条码 */
    private String goodsBarcode;
    /** 商品名称 */
    private String goodsName;
    /** 商品价格 */
    private Double goodsPrice;
    /** 商品重量 */
    private Double goodsWeight;
    /** 商品数量 */
    private Integer goodsQuantity;
}
