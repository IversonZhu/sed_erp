package com.iverson.erp.vo;

import lombok.Data;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/26
 */
@Data
public class UserMVO {
    private String userNo;
    private String userName;
    private String nickName;
    private Integer status;
    private String roleNo;
    private String roleName;
}
