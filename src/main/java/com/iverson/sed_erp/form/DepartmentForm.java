package com.iverson.sed_erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DepartmentForm {
    private String departmentNo;

    @NotBlank(message = "部门名称必填")
    private String name;

    private String parentDepartmentNo;

    private Integer status;
}
