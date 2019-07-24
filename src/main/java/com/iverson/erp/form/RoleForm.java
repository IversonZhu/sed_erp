package com.iverson.erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/22
 */
@Data
public class RoleForm {
    /** 角色编号 */
    private String roleNo;
    /** 角色名称 */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;
    /** 角色状态 */
    private Integer status;
    /** 角色拥有模块 */
    private String module;
}
