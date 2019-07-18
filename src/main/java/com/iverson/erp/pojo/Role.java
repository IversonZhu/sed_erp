package com.iverson.erp.pojo;

import lombok.Data;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/18
 */
@Data
public class Role {
    /** id */
    private int id;
    /** 角色编号 */
    private String roleNo;
    /** 角色名称 */
    private String roleName;
    /** 状态 */
    private Integer status;
    /** 模块 */
    private String module;
}
