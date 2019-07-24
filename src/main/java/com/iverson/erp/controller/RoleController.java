package com.iverson.erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.RoleForm;
import com.iverson.erp.pojo.Role;
import com.iverson.erp.service.RoleService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import com.iverson.erp.vo.RoleVO;
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
 * @date 2019/7/22
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody RoleForm roleForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建角色】参数不正确，userForm = {}", roleForm);
            return ResultVoUtil.error(000,"xxx");
        }
        int result = roleService.create(roleForm);
        if(result == 1){
            log.info("【创建角色】成功 result={}", result);
            return ResultVoUtil.success();
        }
        log.error("【创建角色】失败 result={}", result);
        return ResultVoUtil.error(000,"xxx");
    }

    @PostMapping("/update")
    public ResultVO update(@Valid @RequestBody RoleForm roleForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改角色】参数不正确，userForm = {}", roleForm);
            return ResultVoUtil.error(000,"xxx");
        }
        int result = roleService.update(roleForm);
        if(result == 1){
            log.info("【修改角色】成功 result={}", result);
            return ResultVoUtil.success();
        }
        log.error("【修改角色】失败 result={}", result);
        return ResultVoUtil.error(000,"xxx");
    }

    @GetMapping("/list")
    public ResultVO getList(@RequestParam(name = "roleNo", required = false) String roleNo,
                            @RequestParam(name = "roleName", required = false) String roleName,
                            @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<Role> rolePageInfo = roleService.getList(roleNo, roleName, pageNum, pageSize);
        return ResultVoUtil.success(rolePageInfo);
    }
}
