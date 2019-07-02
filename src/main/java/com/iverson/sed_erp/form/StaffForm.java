package com.iverson.sed_erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class StaffForm {
    private String staffNo;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "收集好吗不能为空")
    private String phoneNumber;
    private Integer age;
    private Integer sex;
    private Date birth;
    private String address;
    private String departmentNo;
}
