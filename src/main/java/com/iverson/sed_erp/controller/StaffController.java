package com.iverson.sed_erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.exception.MarketException;
import com.iverson.sed_erp.form.StaffForm;
import com.iverson.sed_erp.service.StaffService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.ResultVO;
import com.iverson.sed_erp.vo.StaffVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/staff")
@Slf4j
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody StaffForm staffForm, BindingResult bindingResult){
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
    public ResultVO update(@RequestBody StaffForm staffForm){
        int result = staffService.update(staffForm);
        if(result == 1){
            log.info("【创建员工】 更新成功 result = {}",result);
            return ResultVoUtil.success();
        }
        log.error("【创建员工】 更新失败 result = {}",result);
        return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(),ResultEnum.UPDATE_ERROR.getMessage());
    }

    @GetMapping("/list")
    public ResultVO getList(@RequestParam(name = "staffNo",required = false) String staffNo,
                            @RequestParam(name = "name",required = false) String name,
                            @RequestParam(name = "phoneNumber",required = false) String phoneNumber,
                            @RequestParam(name = "sex",required = false) Integer sex,
                            @RequestParam(name = "birth",required = false) String birth,
                            @RequestParam(name = "departmentNo",required = false) String departmentNo,
                            @RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<StaffVO> staffVoPageInfo = staffService.getList(staffNo,name,phoneNumber,sex,birth,departmentNo,pageNum,pageSize);
        return ResultVoUtil.success(staffVoPageInfo);
    }

}
