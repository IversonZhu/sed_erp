package com.iverson.erp.vo;

import com.iverson.erp.pojo.Machine;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/18
 */
@Data
public class ShopVO {
    /** 商店编号 */
    private String shopNo;
    /** 商店名称 */
    private String shopName;
    /** 商店地址 */
    private String shopAddress;
    /** 商店负责人 */
    private String shopLeader;
    /** 负责人手机号码 */
    private String phoneNumber;
    /** 状态 */
    private Integer status;
    /** 机器列表 */
    private List<Machine> machines;
}
