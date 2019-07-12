package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.BrandForm;
import com.iverson.erp.pojo.Brand;
import com.iverson.erp.vo.BrandVO;

import java.util.List;

public interface BrandService {
    int addBrand(BrandForm brandForm);

    PageInfo<Brand> getBrands(String brandNo, String name, Integer status, int pageNum, int pageSize);

    int updateBrandByBrandNo(BrandForm brandForm);

    List<BrandVO> getAll(Integer status);
}
