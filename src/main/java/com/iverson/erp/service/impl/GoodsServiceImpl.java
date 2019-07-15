package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.GoodsForm;
import com.iverson.erp.mapper.GoodsMapper;
import com.iverson.erp.pojo.Goods;
import com.iverson.erp.service.GoodsService;
import com.iverson.erp.util.NoGenerateUtil;
import com.iverson.erp.vo.GoodsVO;
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
        goods.setGoodsNo(NoGenerateUtil.getGoodsNo());
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
        return goodsMapper.update(goods);
    }

    @Override
    public PageInfo<GoodsVO> getList(String goodsNo, String name, String barcode, String categoryNo, String brandNo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsVO> goodsVos = goodsMapper.getList(goodsNo,name,barcode,categoryNo,brandNo);
        PageInfo<GoodsVO> goodsVoPageInfo = new PageInfo<>(goodsVos);
        return goodsVoPageInfo;
    }

    @Override
    public GoodsVO getGoodsByBarcode(String barcode) {
        return goodsMapper.getGoodsByBarcode(barcode);
    }
}
