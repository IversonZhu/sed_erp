package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.BrandForm;
import com.iverson.sed_erp.pojo.Brand;

public interface BrandService {
    void addBrand(BrandForm brandForm);

    PageInfo<Brand> getList(int pageNum, int pageSize);
}
