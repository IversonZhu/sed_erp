package com.iverson.erp.enums;

import lombok.Getter;

@Getter
public enum StaffSexEnum {

    UNKNOW(0,"未知"),
    MAN(1,"男"),
    WOMAN(2,"女");

    private Integer value;
    private String sex;

    StaffSexEnum(Integer value, String sex){
        this.value = value;
        this.sex = sex;
    }
}
