package com.iverson.erp.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 购物车
 * @author Iverson
 * @date 2019/07/13
 */
@Data
public class CartDTO implements Serializable {
    /** 商品条码 */
    private String barcode;
    /** 商品名称 */
    private String name;
    /** 商品价格 */
    private double price;
    /** 商品重量 */
    private double weight;
    /** 商品数量 */
    private int quantity;
    /** 总价格 */
    private double totalPrice;
    /** 总重量 */
    private double totalWeight;
}
