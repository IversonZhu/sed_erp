package com.iverson.erp.api;

import com.iverson.erp.dto.CartDTO;
import com.iverson.erp.dto.OrderDTO;
import com.iverson.erp.enums.ResultEnum;
import com.iverson.erp.exception.MarketException;
import com.iverson.erp.service.OrderService;
import com.iverson.erp.util.RedisUtil;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@RestController
@RequestMapping("api/order")
@Slf4j
public class OrderApi {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private OrderService orderService;

    /**
     * 添加订单
     * @return
     */
    @GetMapping("/create")
    public ResultVO createOrder(@RequestParam(name = "key") String key,
                                @RequestParam(name = "machineNo") String machineNo){
        if(StringUtils.isEmpty(key)){
            log.error("【创建订单】 参数不正确 key={}" ,key);
            throw new MarketException(ResultEnum.PARAM_ERROR);
        }
        //1.获取购物车
        List<CartDTO> cartDTOS = (List<CartDTO>) redisUtil.get(key);
        if(CollectionUtils.isEmpty(cartDTOS)){
            log.error("【创建订单】购物车不能为空");
            throw new MarketException(ResultEnum.CART_EMPTY);
        }
        OrderDTO orderDTO = orderService.createOrder(cartDTOS,machineNo);
        Map<String, String> map = new HashMap<>();
        map.put("orderNo", orderDTO.getOrderNo());
        return ResultVoUtil.success(map);
    }

    /**
     * 取消订单
     * @param key
     * @return
     */
    @GetMapping("/cancel")
    public ResultVO cancelOrder(@RequestParam(name = "key") String key){
        return ResultVoUtil.success();
    }
}
