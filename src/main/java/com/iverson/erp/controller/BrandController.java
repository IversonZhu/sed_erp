package com.iverson.erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.form.BrandForm;
import com.iverson.erp.pojo.Brand;
import com.iverson.erp.service.BrandService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.BrandVO;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 品牌
 * @author Iverson
 * @date 2019/07/13
 */
@RestController
@RequestMapping("/brand")
@Slf4j
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody BrandForm brandForm, BindingResult bindingResult){
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
    public ResultVO list(@RequestParam(name = "brandNo", required = false) String brandNo,
                         @RequestParam(name = "name", required = false) String name,
                         @RequestParam(name = "status", required = false) Integer status,
                         @RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<Brand> brandPageInfo = brandService.getBrands(brandNo, name, status, pageNum, pageSize);
        return ResultVoUtil.success(brandPageInfo);
    }

    @GetMapping("/all")
    public ResultVO all(@RequestParam(name = "status") Integer status){
        List<BrandVO> brandVos = brandService.getAll(status);
        return ResultVoUtil.success(brandVos);
    }

    @PostMapping("/update")
    public ResultVO update(@RequestBody BrandForm brandForm){
        int result = brandService.updateBrandByBrandNo(brandForm);
        if(result == 1){
            log.info("【更新品牌】成功, result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("【更新品牌】失败, result = {}", result);
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
    }
}
