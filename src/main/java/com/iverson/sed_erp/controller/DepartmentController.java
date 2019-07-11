package com.iverson.sed_erp.controller;

import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.form.DepartmentForm;
import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.service.DepartmentService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.DepartmentVo;
import com.iverson.sed_erp.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/list")
    public ResultVo getList(){
        List<Department> departments= departmentService.getList();
        return ResultVoUtil.success(departments);
    }

    @GetMapping("/tree")
    public ResultVo getDepartmentTree(){
        List<DepartmentVo> departmentVos = departmentService.getDepartmentTree();
        return ResultVoUtil.success(departmentVos);
    }
}
