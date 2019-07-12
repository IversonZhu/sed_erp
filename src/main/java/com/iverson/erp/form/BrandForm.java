package com.iverson.erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BrandForm {

    /** 品牌编号 */
    private String brandNo;
    /** 品牌名称 */
    @NotBlank(message = "品牌名称必填")
    private String name;
    /** 状态 */
    private Integer status;
}
