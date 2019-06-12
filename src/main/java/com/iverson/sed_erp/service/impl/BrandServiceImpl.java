package com.iverson.sed_erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.BrandForm;
import com.iverson.sed_erp.mapper.BrandMapper;
import com.iverson.sed_erp.pojo.Brand;
import com.iverson.sed_erp.service.BrandService;
import com.iverson.sed_erp.util.NoGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void addBrand(BrandForm brandForm) {
        Brand brand = new Brand();
        brand.setBrandNo(NoGenerateUtil.getBrandNo());
        brand.setName(brandForm.getName());
        brand.setCreateTime(new Date());
        brand.setModifyTime(new Date());
        brandMapper.addBrand(brand);
    }

    @Override
    public PageInfo<Brand> getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Brand> brands = brandMapper.getList();
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        return brandPageInfo;
    }
}
