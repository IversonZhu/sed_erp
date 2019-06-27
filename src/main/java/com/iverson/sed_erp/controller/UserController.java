package com.iverson.sed_erp.controller;

import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public ResultVo login(){
        return ResultVoUtil.success();
    }

}
