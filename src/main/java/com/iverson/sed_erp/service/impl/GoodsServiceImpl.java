package com.iverson.sed_erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.GoodsForm;
import com.iverson.sed_erp.mapper.GoodsMapper;
import com.iverson.sed_erp.pojo.Goods;
import com.iverson.sed_erp.service.GoodsService;
import com.iverson.sed_erp.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int addOne(GoodsForm goodsForm) {
        Goods goods = new Goods();
        //goods.setGoodsNo(goodsForm.getGoodsNo());
        goods.setName(goodsForm.getName());
        goods.setBarcode(goodsForm.getBarcode());
        goods.setWeight(goodsForm.getWeight());
        goods.setPrice(goodsForm.getPrice());
        goods.setCategoryNo(goodsForm.getCategoryNo());
        goods.setBrandNo(goodsForm.getBrandNo());
        goods.setStore(goodsForm.getStore() == null ? 0 : goodsForm.getStore());
        return goodsMapper.addOne(goods);
    }

    @Override
    public int update(GoodsForm goodsForm) {
        Goods goods = new Goods();
        goods.setGoodsNo(goodsForm.getGoodsNo());
        goods.setName(goodsForm.getName());
        goods.setBarcode(goodsForm.getBarcode());
        goods.setWeight(goodsForm.getWeight());
        goods.setPrice(goodsForm.getPrice());
        goods.setCategoryNo(goodsForm.getCategoryNo());
        goods.setBrandNo(goodsForm.getBrandNo());
        goods.setStore(goodsForm.getStore() == null ? 0 : goodsForm.getStore());
        return goodsMapper.addOne(goods);
    }

    @Override
    public PageInfo<GoodsVo> getList(String goodsNo, String name, String barcode, String categoryNo, String brandNo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsVo> goodsVos = goodsMapper.getList(goodsNo,name,barcode,categoryNo,brandNo);
        PageInfo<GoodsVo> goodsVoPageInfo = new PageInfo<>(goodsVos);
        return goodsVoPageInfo;
    }
}
