package com.iverson.sed_erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.exception.MarketException;
import com.iverson.sed_erp.form.StaffForm;
import com.iverson.sed_erp.service.StaffService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.ResultVo;
import com.iverson.sed_erp.vo.StaffVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/staff")
@Slf4j
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody StaffForm staffForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建员工】 参数不正确 staffForm = {}", staffForm);
            throw new MarketException(ResultEnum.PARAM_ERROR);
        }
        int result = staffService.addOne(staffForm);
        if(result == 1){
            log.info("【创建员工】 插入成功 result = {}",result);
            return ResultVoUtil.success();
        }
        log.error("【创建员工】 插入失败 result = {}",result);
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody StaffForm staffForm){
        int result = staffService.update(staffForm);
        if(result == 1){
            log.info("【创建员工】 更新成功 result = {}",result);
            return ResultVoUtil.success();
        }
        log.error("【创建员工】 更新失败 result = {}",result);
        return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(),ResultEnum.UPDATE_ERROR.getMessage());
    }

    @GetMapping("/list")
    public ResultVo getList(@RequestParam(name = "staffNo") String staffNo,
                            @RequestParam(name = "name") String name,
                            @RequestParam(name = "phoneNumber") String phoneNumber,
                            @RequestParam(name = "sex") Integer sex,
                            @RequestParam(name = "birth") Date birth,
                            @RequestParam(name = "address") String address,
                            @RequestParam(name = "departmentNo") String departmentNo,
                            @RequestParam(name = "pageNum") int pageNum,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<StaffVo> staffVoPageInfo = staffService.getList(staffNo,name,phoneNumber,sex,birth,address,departmentNo,pageNum,pageSize);
        return ResultVoUtil.success(staffVoPageInfo);
    }

}
