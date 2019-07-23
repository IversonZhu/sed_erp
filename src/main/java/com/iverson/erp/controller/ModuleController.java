package com.iverson.erp.controller;

import com.iverson.erp.form.ModuleForm;
import com.iverson.erp.form.RoleForm;
import com.iverson.erp.pojo.Module;
import com.iverson.erp.service.ModuleService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ModuleVO;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/22
 */
@RestController
@RequestMapping("/module")
@Slf4j
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody ModuleForm moduleForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error("【创建模块】 参数不正确 moduleForm={}", moduleForm);
            return ResultVoUtil.error(000,"xxx");
        }
        int result = moduleService.add(moduleForm);
        if (result == 1) {
            log.info("【创建模块】 保存成功 result={}", result);
            return ResultVoUtil.success();
        }
        log.error("【创建模块】 保存失败 result={}", result);
        return ResultVoUtil.error(000,"xxx");
    }

    @PostMapping("/update")
    public ResultVO update(@Valid @RequestBody ModuleForm moduleForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error("【修改模块】 参数不正确 moduleForm={}", moduleForm);
            return ResultVoUtil.error(000,"xxx");
        }
        int result = moduleService.update(moduleForm);
        if (result == 1) {
            log.info("【修改模块】 保存成功 result={}", result);
            return ResultVoUtil.success();
        }
        log.error("【修改模块】 保存失败 result={}", result);
        return ResultVoUtil.error(000,"xxx");
    }

    @GetMapping("/tree")
    public ResultVO tree(){
        List<ModuleVO> modules = moduleService.getTree();
        return ResultVoUtil.success(modules);
    }
}
