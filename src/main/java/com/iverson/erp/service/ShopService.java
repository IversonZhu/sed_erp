package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.pojo.Shop;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
public interface ShopService {


    int create(String shopName);

    PageInfo<Shop> getList(String shopNo, String shopName, Integer status, int pageNum, int pageSize);

    int update(String shopNo, String shopName, Integer status);

    Shop getShopByToken(String tokenNo);
}
