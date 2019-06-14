package com.iverson.sed_erp.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Category {
    /**
     * id
     */
    private int id;
    /**
     * 分类编号
     */
    private String categoryNo;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父级分类编号
     */
    private String parentNo;
    /**
     * 新增时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 子菜单
     */
    private List<Category> categorys;
}
