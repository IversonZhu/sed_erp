package com.iverson.sed_erp.service;

import com.iverson.sed_erp.pojo.Category;
import com.iverson.sed_erp.vo.CategoryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getCategoryTree() {
        List<CategoryVo> categories = categoryService.getCategoryTree();
        System.out.println(categories.toString());
    }
}