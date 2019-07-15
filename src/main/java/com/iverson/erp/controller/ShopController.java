package com.iverson.erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.pojo.Shop;
import com.iverson.erp.service.ShopService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@RestController
@RequestMapping("/token")
@Slf4j
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/create")
    public ResultVO create(@RequestParam(name = "shopName") String shopName){
        int result = shopService.create(shopName);
        if(result == 1) {
            log.info("创建店铺】成功，result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("创建店铺】失败，result = {}", result);
        return ResultVoUtil.error(000,"");
    }

    @GetMapping("/list")
    public ResultVO list(@RequestParam(name = "shopNo", required = false) String shopNo,
                         @RequestParam(name = "shopName", required = false) String shopName,
                         @RequestParam(name = "status", required = false) Integer status,
                         @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<Shop> shopPageInfo = shopService.getList(shopNo,shopName,status,pageNum,pageSize);
        return ResultVoUtil.success(shopPageInfo);
    }

    @GetMapping("/update")
    public ResultVO update(@RequestParam(name = "shopNo", required = false) String shopNo,
                           @RequestParam(name = "shopName", required = false) String shopName,
                           @RequestParam(name = "status", required = false) Integer status){
        int result = shopService.update(shopNo,shopName,status);
        if(result == 1){
            log.info("更新店铺】成功，result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("更新店铺】失败，result = {}", result);
        return ResultVoUtil.error(000,"");
    }
}
