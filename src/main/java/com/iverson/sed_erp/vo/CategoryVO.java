package com.iverson.sed_erp.vo;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVO {
    private String categoryNo;
    private String name;
    private String parentNo;
    private List<CategoryVO> categorys;
}
