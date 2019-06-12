package com.iverson.sed_erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BrandForm {

    /**
     * 品牌名称
     */
    @NotBlank(message = "品牌名称必填")
    private String name;
}
