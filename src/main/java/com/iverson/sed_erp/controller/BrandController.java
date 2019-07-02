package com.iverson.sed_erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.exception.MarketException;
import com.iverson.sed_erp.form.BrandForm;
import com.iverson.sed_erp.pojo.Brand;
import com.iverson.sed_erp.service.BrandService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/brand")
@Slf4j
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody BrandForm brandForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            log.error("【创建品牌】参数不正确，brandForm = {}", brandForm);
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
            //throw new MarketException(ResultEnum.PARAM_ERROR);
        }
        int result = brandService.addBrand(brandForm);
        if(result == 1){
            log.info("【创建品牌】成功，result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("【创建品牌】失败，result = {}", result);
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
    }

    @GetMapping("/list")
    public ResultVo list(@RequestParam(name = "brandNo", required = false) String brandNo,
                         @RequestParam(name = "name", required = false) String name,
                         @RequestParam(name = "pageNum") int pageNum,
                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<Brand> brandPageInfo = brandService.getBrands(brandNo, name, pageNum, pageSize);
        return ResultVoUtil.success(brandPageInfo);
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody BrandForm brandForm){
        int result = brandService.updateBrandByBrandNo(brandForm);
        if(result == 1){
            log.info("【更新品牌】成功, result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("【更新品牌】失败, result = {}", result);
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
    }
}
