package com.iverson.erp.api;

import com.iverson.erp.dto.CartDTO;
import com.iverson.erp.service.GoodsService;
import com.iverson.erp.util.KeyUtil;
import com.iverson.erp.util.RedisUtil;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.CartVO;
import com.iverson.erp.vo.GoodsVO;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@RestController
@RequestMapping("api/goods")
@Slf4j
public class GoodsApi {

    private static final int EXPIRE_TIME = 7200;

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/get")
    public ResultVO getCart(@RequestParam(name = "barcode") String barcode,
                            @RequestParam(name = "key", required = false) String key){
        CartVO cartVO = new CartVO();
        if(StringUtils.isEmpty(barcode)) {
            log.info("【二维码查找商品】条码为空 barcode = {}" , barcode);
            return ResultVoUtil.error(000,"");
        }
        GoodsVO goods = goodsService.getGoodsByBarcode(barcode);
        if(goods == null){
            log.info("【二维码查找商品】 没找到 result = {}" , "null");
            return ResultVoUtil.error(000,"");
        }
        CartDTO cartDTO = new CartDTO();
        BeanUtils.copyProperties(goods,cartDTO);
        if(StringUtils.isEmpty(key)){
            cartDTO.setQuantity(1);
            cartDTO.setTotalPrice(cartDTO.getPrice());
            cartDTO.setTotalWeight(cartDTO.getWeight());
            String temp_key = KeyUtil.getKey();
            List<CartDTO> cartDTOS = new ArrayList<>();
            cartDTOS.add(cartDTO);
            redisUtil.set(temp_key,cartDTOS,EXPIRE_TIME);
            cartVO.setKey(temp_key);
            cartVO.setCartDTOS(cartDTOS);
        }else{
            List<CartDTO> cartDtos = (List<CartDTO>)redisUtil.get(key);

            if(cartDtos != null && cartDtos.size()>0){
                CartDTO cartDTOTemp = null;
                for(CartDTO temp : cartDtos){
                    if(temp.getBarcode().equals(cartDTO.getBarcode())){
                        temp.setQuantity(temp.getQuantity() + 1);
                        temp.setTotalPrice(temp.getPrice() * temp.getQuantity());
                        temp.setTotalWeight(temp.getWeight() * temp.getQuantity());
                        cartDTOTemp = temp;
                        break;
                    }
                }
                if(cartDTOTemp == null){
                    cartDTO.setQuantity(1);
                    cartDTO.setTotalPrice(cartDTO.getPrice() * cartDTO.getQuantity());
                    cartDTO.setTotalWeight(cartDTO.getWeight() * cartDTO.getQuantity());
                    cartDtos.add(cartDTO);
                }
                cartVO.setKey(key);
                cartVO.setCartDTOS(cartDtos);
                redisUtil.set(key,cartDtos,EXPIRE_TIME);
            }else{
                cartDTO.setQuantity(1);
                cartDTO.setTotalPrice(cartDTO.getPrice() * cartDTO.getQuantity());
                cartDTO.setTotalWeight(cartDTO.getWeight() * cartDTO.getQuantity());
                List<CartDTO> cartDTOS = new ArrayList<>();
                cartDTOS.add(cartDTO);
                cartVO.setKey(key);
                cartVO.setCartDTOS(cartDTOS);
                redisUtil.set(key,cartDTOS,EXPIRE_TIME);
            }
        }
        return ResultVoUtil.success(cartVO);
    }
}
