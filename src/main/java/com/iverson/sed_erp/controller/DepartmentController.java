package com.iverson.sed_erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.exception.MarketException;
import com.iverson.sed_erp.form.DepartmentForm;
import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.service.DepartmentService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody DepartmentForm departmentForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            log.error("【创建部门】参数不正确，departmentForm = {}", departmentForm);
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
            //throw new MarketException(ResultEnum.PARAM_ERROR);
        }
        int result = departmentService.addOne(departmentForm);
        if(result == 1) {
            log.info("【创建部门】成功，result = {}", result);
            return ResultVoUtil.success();
        }
        log.error("【创建部门】失败，result = {}", result);
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody DepartmentForm departmentForm){
        int result = departmentService.updateByNo(departmentForm);
        if(result == 1){
            log.info("【更新部门】成功，result = {}", result);
            return ResultVoUtil.success();
        }
        log.info("【更新部门】失败，result = {}", result);
        return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(),ResultEnum.UPDATE_ERROR.getMessage());
    }

    @GetMapping("/getList")
    public ResultVo getList(@RequestParam(name = "departmentNo", required = false) String departmentNo,
                            @RequestParam(name = "name",required = false) String name,
                            @RequestParam(name = "status", required = false) Integer status,
                            @RequestParam(name = "pageNum") int pageNum,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<Department> departmentPageInfo = departmentService.getList(departmentNo,name,status,pageNum,pageSize);
        return ResultVoUtil.success(departmentPageInfo);
    }
}
