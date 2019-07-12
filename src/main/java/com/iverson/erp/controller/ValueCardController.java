package com.iverson.erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.exception.MarketException;
import com.iverson.erp.form.ValueCardForm;
import com.iverson.erp.pojo.ValueCard;
import com.iverson.erp.service.ValueCardService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 储值卡
 * @author Iverson
 * @date 2019/07/13
 */

@Controller
@RequestMapping("/card/value")
@Slf4j
public class ValueCardController {

    @Autowired
    private ValueCardService valueCardService;

    @PostMapping("/create")
    @ResponseBody
    public ResultVO create(@Valid @RequestBody ValueCardForm valueCardForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建储值卡】参数不正确，valueCardForm = {}", valueCardForm);
            new MarketException(ResultEnum.PARAM_ERROR);
        }
        int result = valueCardService.addOne(valueCardForm);
        if(result == 1){
            log.info("【创建储值卡】插入成功，result = {}", result);
            return ResultVoUtil.success();
        }else{
            log.error("【创建储值卡】插入不成功，result = {}", result);
            return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
        }
    }

    @GetMapping("/list")
    @ResponseBody
    public ResultVO get(@RequestParam(name = "cardNo", required = false) String cardNo,
                        @RequestParam(name = "holder", required = false) String holder,
                        @RequestParam(name = "phoneNumber", required = false) String phoneNumber,
                        @RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
                        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<ValueCard> valueCardPageInfo = valueCardService.getCards(cardNo, holder, phoneNumber,pageNum, pageSize);
        return ResultVoUtil.success(valueCardPageInfo);
    }

    @PostMapping("update")
    @ResponseBody
    public ResultVO update(@RequestBody ValueCardForm valueCardForm){
        int result = valueCardService.updateValueCardByCardNo(valueCardForm);
        if(result == 1){
            log.info("【创建储值卡】更新成功，result = {}", result);
            return ResultVoUtil.success();
        }else{
            log.error("【创建储值卡】更新不成功，result = {}", result);
            return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(),ResultEnum.UPDATE_ERROR.getMessage());
        }
    }
}
