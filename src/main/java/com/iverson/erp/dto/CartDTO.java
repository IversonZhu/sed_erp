package com.iverson.erp.dto;

import lombok.Data;

/**
 * 购物车
 * @author Iverson
 * @date 2019/07/13
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
