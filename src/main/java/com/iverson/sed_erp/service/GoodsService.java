package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.GoodsForm;
import com.iverson.sed_erp.vo.GoodsVo;

public interface GoodsService {
    int addOne(GoodsForm goodsForm);

    int update(GoodsForm goodsForm);

    PageInfo<GoodsVo> getList(String goodsNo, String name, String barcode, String categoryNo, String brandNo, int pageNum, int pageSize);
}
