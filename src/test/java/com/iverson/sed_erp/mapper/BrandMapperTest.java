package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Brand;
import com.iverson.sed_erp.util.NoGenerateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandMapperTest {

    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void addBrand() {
        Brand brand = new Brand();
        brand.setBrandNo(NoGenerateUtil.getBrandNo());
        brand.setName("李宁");
        brand.setCreateTime(new Date());
        brand.setModifyTime(new Date());
        brandMapper.addBrand(brand);
        //Assert.assertEquals(1,result);
    }

    @Test
    public void getBrandByBrandNo() {
        Brand brand = brandMapper.getBrandByBrandNo("bn20190611112212788710");
        Assert.assertNotNull(brand);
    }
}