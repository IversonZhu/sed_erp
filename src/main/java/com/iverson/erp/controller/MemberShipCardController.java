package com.iverson.erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.exception.MarketException;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.form.MemberShipCardForm;
import com.iverson.erp.pojo.MemberShipCard;
import com.iverson.erp.service.MemberShipCardService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * 会员卡
 * @author Iverson
 * @date 2019/07/13
 */

@RestController
@RequestMapping("/card/member")
@Slf4j
public class MemberShipCardController {

    @Autowired
    private MemberShipCardService memberShipCardService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody MemberShipCardForm memberShipCardForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建会员卡】参数不正确，valueCardForm = {}", memberShipCardForm);
            new MarketException(ResultEnum.PARAM_ERROR);
        }
        int result = memberShipCardService.addOne(memberShipCardForm);
        if(result == 1){
            log.info("【创建会员卡】插入成功, result = {}", result);
            return ResultVoUtil.success();
        }else{
            log.error("【创建会员卡】插入不成功，result = {}", result);
            return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(),ResultEnum.INSERT_ERROR.getMessage());
        }
    }

    @GetMapping("/list")
    public ResultVO getMemberShipCards(@RequestParam(name = "cardNo", required = false) String cardNo,
                                       @RequestParam(name = "holder", required = false) String holder,
                                       @RequestParam(name = "phoneNumber", required = false) String phoneNumber,
                                       @RequestParam(name = "type", required = false) Integer type,
                                       @RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
                                       @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<MemberShipCard> memberShipCardPageInfo = memberShipCardService.getMemberShipCards(cardNo, holder, phoneNumber, type, pageNum, pageSize);
        return ResultVoUtil.success(memberShipCardPageInfo);
    }

    @PostMapping("/update")
    public ResultVO update(@RequestBody MemberShipCardForm memberShipCardForm){
        int result = memberShipCardService.updateMemberShipCardByCardNo(memberShipCardForm);
        if(result == 1){
            log.info("【修改会员卡】修改成功,result = {}", result);
            return ResultVoUtil.success();
        }else{
            log.error("【修改会员卡】修改不成功，result = {}", result);
            return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(),ResultEnum.UPDATE_ERROR.getMessage());
        }
    }
}
