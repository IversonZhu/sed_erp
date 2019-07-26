package com.iverson.erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.form.LoginForm;
import com.iverson.erp.form.UserForm;
import com.iverson.erp.pojo.User;
import com.iverson.erp.service.UserService;
import com.iverson.erp.util.KeyUtil;
import com.iverson.erp.util.RedisUtil;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import com.iverson.erp.vo.UserMVO;
import com.iverson.erp.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 * @author Iverson
 * @date 2019/07/13
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public ResultVO login(@Valid @RequestBody LoginForm loginForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【用户登录】参数不正确，loginForm = {}", loginForm);
            return ResultVoUtil.error(111,"xxx");
        }
        UserVO userVO = userService.login(loginForm);
        if (userVO == null){
            log.error("【用户登录】失败   用户不存在");
            return ResultVoUtil.error(111,"xxx");
        }
        String token = KeyUtil.getKey();
        userVO.setToken(token);
        redisUtil.set(token,userVO,3600*24*7);//7天需要重新登录
        return ResultVoUtil.success(userVO);
    }

    @GetMapping("/loginOut")
    public ResultVO loginOut(HttpServletRequest request){
        redisUtil.del(request.getHeader("token"));
        return ResultVoUtil.success();
    }

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody UserForm userForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建用户】参数不正确，userForm = {}", userForm);
            return ResultVoUtil.error(000,"xxx");
        }
        int result = userService.add(userForm);
        if(result == 1){
            log.info("【创建用户】成功 result={}", result);
            return ResultVoUtil.success();
        }
        log.error("【创建用户】失败 result={}", result);
        return ResultVoUtil.error(000,"xxx");
    }

    @GetMapping("/list")
    public ResultVO getList(@RequestParam(name = "userNo", required = false) String userNo,
                            @RequestParam(name = "nickName", required = false) String nickName,
                            @RequestParam(name = "status", required = false) Integer status,
                            @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<UserMVO> userMVOPageInfo = userService.getList(userNo,nickName,status,pageNum,pageSize);
        return ResultVoUtil.success(userMVOPageInfo);
    }

    @PostMapping("/update")
    public ResultVO update(@Valid @RequestBody UserForm userForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改用户】参数不正确，userForm = {}", userForm);
            return ResultVoUtil.error(000,"xxx");
        }
        int result = userService.update(userForm);
        if(result == 1){
            log.info("【修改用户】成功 result={}", result);
            return ResultVoUtil.success();
        }
        log.error("【修改用户】失败 result={}", result);
        return ResultVoUtil.error(000,"xxx");
    }
}
