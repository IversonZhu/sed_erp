package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.BrandForm;
import com.iverson.sed_erp.pojo.Brand;

public interface BrandService {
    int addBrand(BrandForm brandForm);

    PageInfo<Brand> getBrands(String brandNo, String name, int pageNum, int pageSize);

    int updateBrandByBrandNo(BrandForm brandForm);
}
