package com.iverson.erp.pojo;

import lombok.Data;

@Data
public class User {
    /** id */
    private int id;
    /** 用户编号 */
    private String userNo;
    /** 角色编号 */
    private String roleNo;
    /** 用户名 */
    private String userName;
    /** 用户昵称 */
    private String nickName;
    /** 密码 */
    private String password;
    /** 状态 */
    private Integer status;
}
