package com.iverson.sed_erp.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    /** id */
    private int id;
    /** 部门编号 */
    private String departmentNo;
    /** 部门名称 */
    private String name;
    /** 父级No */
    private String parentDepartmentNo;
    /** 状态 */
    private Integer status;
    /** 子部门 */
    private List<Department> departments;
}
