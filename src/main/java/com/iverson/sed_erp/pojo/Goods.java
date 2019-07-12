package com.iverson.sed_erp.pojo;

import lombok.Data;

@Data
public class Goods {
    /** id */
    private int id;
    /** 商品编号 */
    private String goodsNo;
    /** 商品名称 */
    private String name;
    /** 商品条码 */
    private String barcode;
    /** 商品重量 */
    private Double weight;
    /** 商品价格 */
    private Double price;
    /** 分类编号 */
    private String categoryNo;
    /** 品牌编号 */
    private String brandNo;
    /** 库存 */
    private Integer store;
}
