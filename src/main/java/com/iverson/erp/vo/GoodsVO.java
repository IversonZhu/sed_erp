package com.iverson.erp.vo;

import lombok.Data;

@Data
public class GoodsVO {
    private String goodsNo;
    private String name;
    private String barcode;
    private double weight;
    private double price;
    private String categoryNo;
    private String categoryName;
    private String brandNo;
    private String brandName;
    private String store;
}
