package com.iverson.erp.vo;

import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/24
 */
@Data
public class RoleVO {
    /** 角色编号 */
    private String roleNo;
    /** 角色名称 */
    private String roleName;
    /** 状态 */
    private Integer status;
    /** 模块 */
    private List<String> modules;
}
