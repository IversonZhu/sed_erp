package com.iverson.erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GoodsForm {
    /** 商品编号 */
    private String goodsNo;
    /** 商品名称 */
    @NotBlank(message = "商品名称不能为空")
    private String name;
    /** 商品条码 */
    @NotBlank(message = "商品条码不能为空")
    private String barcode;
    /** 商品重量 */
    @NotNull(message = "商品重量不能为空")
    private Double weight;
    /** 商品价格 */
    @NotNull(message = "商品价格不能为空")
    private Double price;
    /** 分类编号 */
    @NotBlank(message = "分类编号不能为空")
    private String categoryNo;
    /** 品牌编号 */
    @NotBlank(message = "品牌编号不能为空")
    private String brandNo;
    /** 库存 */
    @NotNull(message = "库存不能为空")
    private Integer store;
}
