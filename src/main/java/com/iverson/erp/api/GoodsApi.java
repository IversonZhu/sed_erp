package com.iverson.erp.api;

import com.iverson.erp.service.GoodsService;
import com.iverson.erp.util.ResultVoUtil;
import com.iverson.erp.vo.GoodsVO;
import com.iverson.erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/get")
    public ResultVO getGoods(@RequestParam(name = "barcode") String barcode){
        if(StringUtils.isEmpty(barcode)) {
            log.info("【二维码查找商品】 barcode = {}" , barcode);
            return ResultVoUtil.error(000,"");
        }
        GoodsVO goods = goodsService.getGoodsByBarcode(barcode);
        if(goods == null){
            log.info("【二维码查找商品】 没找到 result = {}" , "null");
            return ResultVoUtil.error(000,"");
        }
        return ResultVoUtil.success(goods);
    }
}
