package com.iverson.erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.form.ShopForm;
import com.iverson.erp.service.ShopService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import com.iverson.erp.vo.ShopVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@RestController
@RequestMapping("/shop")
@Slf4j
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/create")
    public ResultVO create(@Valid @RequestBody ShopForm shopForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建商店】参数不正确，shopForm = {}", shopForm);
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
        }
        int result = shopService.create(shopForm);
        if(result == 1) {
            return ResultVoUtil.success();
        }
        log.error("【创建商店】插入失败，result = {}", result);
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
    }

    @GetMapping("/list")
    public ResultVO list(@RequestParam(name = "shopNo", required = false) String shopNo,
                         @RequestParam(name = "shopName", required = false) String shopName,
                         @RequestParam(name = "shopLeader", required = false) String shopLeader,
                         @RequestParam(name = "status", required = false) Integer status,
                         @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<ShopVO> shopVOPageInfo = shopService.getList(shopNo,shopName,shopLeader,status,pageNum,pageSize);
        return ResultVoUtil.success(shopVOPageInfo);
    }

    @PostMapping("/update")
    public ResultVO update(@Valid @RequestBody ShopForm shopForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error("【更新商店】参数不正确，shopForm = {}", shopForm);
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
        }
        int result = shopService.update(shopForm);
        if(result == 1){
            log.info("更新店铺】成功，result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("更新店铺】失败，result = {}", result);
        return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(), ResultEnum.UPDATE_ERROR.getMessage());
    }
}
