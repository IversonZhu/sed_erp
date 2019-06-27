package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Goods;
import com.iverson.sed_erp.util.NoGenerateUtil;
import com.iverson.sed_erp.vo.GoodsVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMapperTest {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void addOne() {
        Goods goods = new Goods();
        goods.setGoodsNo(NoGenerateUtil.getGoodsNo());
        goods.setBarcode("6932346702376");
        //6921734971036  固体胶
        //6901285991219  怡宝纯净水
        //6932346702376  乐趣生活马克杯
        goods.setName("乐趣生活 马克杯");
        goods.setWeight(300.00);//单位 g
        goods.setPrice(7.50);//单位 元
        goods.setCategoryNo("cn20190627120101343207");
        goods.setBrandNo("bn20190627114432887479");
        goods.setStore(100);
        goods.setCreateTime(new Date());
        goods.setModifyTime(new Date());
        int result = goodsMapper.addOne(goods);
        System.out.println("结果: " + result);
    }

    @Test
    public void updateGoodsByGoodsNo() {
    }

    @Test
    public void getStore() {
    }

    @Test
    public void getGoodsList(){
        List<GoodsVo> goodsVos = goodsMapper.searchGoods(null,null,null,null,null,null,null);
        Assert.assertNotNull(goodsVos);
    }

    @Test
    public void getGoodsByBarcode(){
        GoodsVo goodsVo = goodsMapper.getGoodsByBarcode("6921734971036");
        Assert.assertNotNull(goodsVo);
    }
}