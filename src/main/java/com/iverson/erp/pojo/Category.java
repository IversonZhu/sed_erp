package com.iverson.erp.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    /** id */
    private int id;
    /** 分类编号 */
    private String categoryNo;
    /** 分类名称 */
    private String name;
    /** 父级分类编号 */
    private String parentNo;
    /** 子菜单 */
    private List<Category> categorys;
}
