package com.iverson.sed_erp.vo;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentVO {
    private String departmentNo;
    private String name;
    private Integer status;
    private String parentDepartmentNo;
    private List<DepartmentVO> departments;
}
