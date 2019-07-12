package com.iverson.sed_erp.controller;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.dto.OrderDTO;
import com.iverson.sed_erp.exception.MarketException;
import com.iverson.sed_erp.service.OrderService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ResultVO list(@RequestParam(name = "orderNo", required = false) String orderNo,
                         @RequestParam(name = "machineNo", required = false) String machineNo,
                         @RequestParam(name = "orderStatus", required = false) Integer orderStatus,
                         @RequestParam(name = "payStatus", required = false) Integer payStatus,
                         @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<OrderDTO> orderDTOPageInfo = orderService.getList(orderNo,machineNo,orderStatus,payStatus,pageNum,pageSize);
        return ResultVoUtil.success(orderDTOPageInfo);
    }

    @GetMapping("/detail")
    public ResultVO detail(@RequestParam("orderNo") String orderNo){
        try{
            OrderDTO orderDTO = orderService.findOne(orderNo);
            return ResultVoUtil.success(orderDTO);
        }catch (MarketException e){
            log.error("【卖家端查询订单详情】发生异常{}",e);
            //异常处理
            return ResultVoUtil.error(1,"dddd");
        }
    }
}
