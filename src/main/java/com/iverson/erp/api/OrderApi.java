package com.iverson.erp.api;

import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@RestController
@RequestMapping("/api/order")
public class OrderApi {

    @GetMapping("test")
    public ResultVO test(){
        System.out.println("test");
        return ResultVoUtil.success();
    }
}
