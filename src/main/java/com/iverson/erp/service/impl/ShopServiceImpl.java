package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.enums.ShopStatusEnum;
import com.iverson.erp.form.ShopForm;
import com.iverson.erp.mapper.ShopMapper;
import com.iverson.erp.pojo.Machine;
import com.iverson.erp.pojo.Shop;
import com.iverson.erp.service.MachineService;
import com.iverson.erp.service.ShopService;
import com.iverson.erp.vo.ShopVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public int create(ShopForm shopForm) {
        Shop shop = new Shop();
        shop.setShopName(shopForm.getShopName());
        shop.setShopLeader(shopForm.getShopLeader());
        shop.setPhoneNumber(shopForm.getPhoneNumber());
        shop.setShopAddress(shopForm.getShopAddress());
        shop.setStatus(ShopStatusEnum.NORMAL.getCode());
        return shopMapper.addOne(shop);
    }

    @Override
    public PageInfo<ShopVO> getList(String shopNo, String shopName, String shopLeader,Integer status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shop> shops = shopMapper.getList(shopNo,shopName,shopLeader,status);
        List<ShopVO> shopVOS = new ArrayList<>();
        for(Shop shop : shops){
            ShopVO shopVO = new ShopVO();
            BeanUtils.copyProperties(shop,shopVO);
            List<Machine> machines = machineService.getByShopNo(shop.getShopNo());
            shopVO.setMachines(machines);
            shopVOS.add(shopVO);
        }
        PageInfo<ShopVO> shopPageInfo = new PageInfo<>(shopVOS);
        return shopPageInfo;
    }

    @Override
    public int update(ShopForm shopForm) {
        Shop shop = new Shop();
        shop.setShopNo(shopForm.getShopNo());
        shop.setShopName(shopForm.getShopName());
        shop.setShopLeader(shopForm.getShopLeader());
        shop.setPhoneNumber(shopForm.getPhoneNumber());
        shop.setShopAddress(shopForm.getShopAddress());
        shop.setStatus(shopForm.getStatus());
        return shopMapper.update(shop);
    }
}
