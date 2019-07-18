package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.enums.ShopStatusEnum;
import com.iverson.erp.mapper.ShopMapper;
import com.iverson.erp.pojo.Machine;
import com.iverson.erp.pojo.Shop;
import com.iverson.erp.service.MachineService;
import com.iverson.erp.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private MachineService machineService;

    @Override
    public int create(String shopName) {
        Shop shop = new Shop(shopName);
        return shopMapper.addOne(shop);
    }

    @Override
    public PageInfo<Shop> getList(String shopNo, String shopName, Integer status,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shop> shops = shopMapper.getList(shopNo,shopName,status);
        for(Shop shop : shops){
            List<Machine> machines = machineService.getByShopNo(shop.getShopNo());

        }
        PageInfo<Shop> shopPageInfo = new PageInfo<>(shops);
        return shopPageInfo;
    }

    @Override
    public int update(String shopNo, String shopName, Integer status) {
        Shop shop = new Shop();
        shop.setShopNo(shopNo);
        shop.setShopName(shopName);
        shop.setStatus(status);
        return shopMapper.update(shop);
    }

    @Override
    public Shop getShopByToken(String tokenNo) {
        return shopMapper.getShopByToken(tokenNo, ShopStatusEnum.NORMAL.getCode());
    }
}
