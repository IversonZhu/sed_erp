package com.iverson.erp.controller;

import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Iverson
 * @class LogController
 * @date 2019/7/29
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @GetMapping("/list")
    public ResultVO list(@RequestParam(name = "pageNum", defaultValue = "1") String pageNum,
                         @RequestParam(name = "pageSize", defaultValue = "10") String pageSize){
        return ResultVoUtil.success();
    }
}
