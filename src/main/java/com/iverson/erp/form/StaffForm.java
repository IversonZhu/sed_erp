package com.iverson.erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StaffForm {
    private String staffNo;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "商店不能为空")
    private String shopNo;
    @NotBlank(message = "手机号码不能为空")
    private String phoneNumber;
    private Integer age;
    private Integer sex;
    private String birth;
    private String address;
    private String departmentNo;
}
