package com.iverson.sed_erp.service;

import com.iverson.sed_erp.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    List<CategoryVO> getCategoryTree();

    int addOne(String name, String parentNo);

    int updateCategoryByCategoryNo(String categoryNo, String name, String parentNo);
}
