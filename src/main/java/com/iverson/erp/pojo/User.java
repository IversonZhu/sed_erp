package com.iverson.erp.pojo;

import lombok.Data;

@Data
public class User {
    /** id */
    private int id;
    /** 用户编号 */
    private String userNo;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String password;
    /** 用户昵称 */
    private String nickName;
    /** 可见模块 */
    private String module;
}
