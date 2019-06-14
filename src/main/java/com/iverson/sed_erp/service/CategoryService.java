package com.iverson.sed_erp.service;

import com.iverson.sed_erp.vo.CategoryVo;

import java.util.List;

public interface CategoryService {

    List<CategoryVo> getCategoryTree();

    int addOne(String name, String parentNo);

    int updateCategoryByCategoryNo(String categoryNo, String name, String parentNo);
}
