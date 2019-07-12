package com.iverson.sed_erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.BrandStatusEnum;
import com.iverson.sed_erp.form.BrandForm;
import com.iverson.sed_erp.mapper.BrandMapper;
import com.iverson.sed_erp.pojo.Brand;
import com.iverson.sed_erp.service.BrandService;
import com.iverson.sed_erp.util.NoGenerateUtil;
import com.iverson.sed_erp.vo.BrandVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    @Transactional
    public int addBrand(BrandForm brandForm) {
        Brand brand = new Brand();
        brand.setBrandNo(NoGenerateUtil.getBrandNo());
        brand.setName(brandForm.getName());
        brand.setStatus(BrandStatusEnum.NORMAL.getCode());
        return brandMapper.addOne(brand);
    }

    @Override
    public PageInfo<Brand> getBrands(String brandNo,String name, Integer status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Brand> brands = brandMapper.getList(brandNo,name,status);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        return brandPageInfo;
    }

    @Override
    @Transactional
    public int updateBrandByBrandNo(BrandForm brandForm) {
        Brand brand = new Brand();
        brand.setBrandNo(brandForm.getBrandNo());
        brand.setName(brandForm.getName());
        brand.setStatus(brandForm.getStatus());
        return brandMapper.update(brand);
    }

    @Override
    public List<BrandVO> getAll(Integer status) {
        return brandMapper.getAll(status);
    }
}
