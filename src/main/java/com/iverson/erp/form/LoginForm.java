package com.iverson.erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/19
 */
@Data
public class LoginForm {

    /** 用户名 */
    @NotBlank(message = "用户名不能为空")
    private String userName;
    /** 密码 */
    @NotBlank(message = "密码不能为空")
    private String password;
}
