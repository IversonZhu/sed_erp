package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.GoodsForm;
import com.iverson.erp.vo.GoodsVO;

public interface GoodsService {
    int addOne(GoodsForm goodsForm);

    int update(GoodsForm goodsForm);

    PageInfo<GoodsVO> getList(String goodsNo, String name, String barcode, String categoryNo, String brandNo, int pageNum, int pageSize);

    GoodsVO getGoodsByBarcode(String barcode);
}
