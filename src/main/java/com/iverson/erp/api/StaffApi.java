package com.iverson.erp.api;

import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/29
 */
@RestController
@RequestMapping("/api//staff")
public class StaffApi {

    public ResultVO login(){
        return ResultVoUtil.success();
    }
}
