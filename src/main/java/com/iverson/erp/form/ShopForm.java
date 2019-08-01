package com.iverson.erp.form;

import lombok.Data;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/8/1
 */
@Data
public class ShopForm {
    private String shopNo;
    private String shopName;
    private String shopLeader;
    private String phoneNumber;
    private String shopAddress;
    private Integer status;
}
