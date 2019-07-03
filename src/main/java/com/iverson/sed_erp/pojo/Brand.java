package com.iverson.sed_erp.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Brand {
    /** id */
    private int id;
    /** 品牌编号 */
    private String brandNo;
    /** 品牌名称 */
    private String name;
    /** 状态 */
    private Integer status;
}
