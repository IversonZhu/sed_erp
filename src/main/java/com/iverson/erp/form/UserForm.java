package com.iverson.erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/19
 */
@Data
public class UserForm {
    private String userNo;
    @NotBlank(message = "角色编号不能为空")
    private String roleNo;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "昵称不能为空")
    private String nickName;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotNull(message = "状态不能为空")
    private Integer status;
}