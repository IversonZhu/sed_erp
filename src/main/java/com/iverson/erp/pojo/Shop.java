package com.iverson.erp.pojo;

import com.iverson.erp.enums.ShopStatusEnum;
import com.iverson.erp.util.NoGenerateUtil;
import com.iverson.erp.util.TokenUtil;
import lombok.Data;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@Data
public class Shop {
    /** id */
    private int id;
    /** 商店编号 */
    private String shopNo;
    /** 商店名称 */
    private String shopName;
    /** 商店地址 */
    private String shopAddress;
    /** 商店负责人 */
    private String principal;
    /** 负责人手机号码 */
    private String phoneNumber;
    /** 鉴权token */
    private String token;
    /** 状态 */
    private Integer status;

    public Shop(){

    }

    public Shop(String shopName){
        this.shopNo = NoGenerateUtil.getShopNo();
        this.shopName = shopName;
        this.token = TokenUtil.getInstance().getToken();
        this.status = ShopStatusEnum.NORMAL.getCode();
    }
}
