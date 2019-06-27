package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.util.NoGenerateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void addOne() {
        //int result = categoryMapper.addOne("551001","小明","551" ,new Date(), new Date());
        int result = categoryMapper.addOne(NoGenerateUtil.getCategoryNo(),"玻璃制品","cn20190627111459329286", new Date(), new Date());
        //int result = categoryMapper.addOne(NoGenerateUtil.getCategoryNo(),"胶水","cn20190627111816675021", new Date(), new Date());

        System.out.println("结果: " + result);
    }
}