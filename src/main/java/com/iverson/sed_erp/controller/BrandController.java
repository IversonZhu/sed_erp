package com.iverson.sed_erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.exception.MarketException;
import com.iverson.sed_erp.form.BrandForm;
import com.iverson.sed_erp.mapper.BrandMapper;
import com.iverson.sed_erp.pojo.Brand;
import com.iverson.sed_erp.service.BrandService;
import com.iverson.sed_erp.util.NoGenerateUtil;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/brand")
@Slf4j
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    @ResponseBody
    public ResultVo create(@Valid @RequestBody BrandForm brandForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            log.error("【创建品牌】参数不正确，brandForm = {}", brandForm);
            throw new MarketException(ResultEnum.PARAM_ERROR);
        }
        brandService.addBrand(brandForm);
        return ResultVoUtil.success();
    }

    @GetMapping("/list")
    @ResponseBody
    public ResultVo list(@RequestParam(value = "pageNum",required = true) int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<Brand> brandPageInfo = brandService.getList(pageNum, pageSize);
        return ResultVoUtil.success(brandPageInfo);
    }
}
