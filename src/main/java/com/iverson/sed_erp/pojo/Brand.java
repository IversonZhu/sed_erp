package com.iverson.sed_erp.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Brand {
    private int id;
    private String brandNo;
    private String name;
    private int status;
    private Date createTime;
    private Date modifyTime;
}
