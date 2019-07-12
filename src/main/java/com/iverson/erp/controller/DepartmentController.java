package com.iverson.erp.controller;

import com.iverson.erp.vo.DepartmentVO;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.form.DepartmentForm;
import com.iverson.erp.pojo.Department;
import com.iverson.erp.service.DepartmentService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门
 * @author Iverson
 * @date 2019/07/13
 */

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody DepartmentForm departmentForm, BindingResult bindingResult){
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
    public ResultVO update(@RequestBody DepartmentForm departmentForm){
        int result = departmentService.updateByNo(departmentForm);
        if(result == 1){
            log.info("【更新部门】成功，result = {}", result);
            return ResultVoUtil.success();
        }
        log.info("【更新部门】失败，result = {}", result);
        return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(),ResultEnum.UPDATE_ERROR.getMessage());
    }

    @GetMapping("/list")
    public ResultVO getList(){
        List<Department> departments= departmentService.getList();
        return ResultVoUtil.success(departments);
    }

    @GetMapping("/tree")
    public ResultVO getDepartmentTree(){
        List<DepartmentVO> departmentVos = departmentService.getDepartmentTree();
        return ResultVoUtil.success(departmentVos);
    }
}
