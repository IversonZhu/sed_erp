package com.iverson.erp.controller;

import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 * @author Iverson
 * @date 2019/07/13
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public ResultVO login(){
        return ResultVoUtil.success();
    }

}
