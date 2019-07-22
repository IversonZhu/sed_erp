package com.iverson.erp.form;

import lombok.Data;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/22
 */
@Data
public class ModuleForm {
    /** 模块编号 */
    private String no;
    /** 父级编号 */
    private String parentNo;
    /** 模块标题 */
    private String title;
    /** 模块图标 */
    private String icon;
    /** 模块路由路径 */
    private String path;
    /** 是否页面展示 */
    private Integer page;
}
