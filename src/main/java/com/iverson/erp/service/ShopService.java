package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.ShopForm;
import com.iverson.erp.pojo.Shop;
import com.iverson.erp.vo.ShopVO;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
public interface ShopService {


    int create(ShopForm shopForm);

    PageInfo<ShopVO> getList(String shopNo, String shopName, String shopLeader, Integer status, int pageNum, int pageSize);

    int update(ShopForm shopForm);
}
