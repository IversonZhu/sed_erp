package com.iverson.sed_erp.dto;

import lombok.Data;

@Data
public class CartDTO {
    /** 商品编号 */
    private String goodsNo;
    /** 商品数量 */
    private Integer goodsQuantity;

    public CartDTO(){

    }
}
