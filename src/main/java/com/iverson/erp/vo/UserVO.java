package com.iverson.erp.vo;

import lombok.Data;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/19
 */
@Data
public class UserVO {
    /** 鉴权token */
    private String token;
    /** 用户编号 */
    private String userNo;
    /** 昵称 */
    private String nickName;
    /** 角色名称 */
    private String roleName;
    /** 可见模块 */
    private String module;
}
