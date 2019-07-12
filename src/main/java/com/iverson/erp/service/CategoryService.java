package com.iverson.erp.service;

import com.iverson.erp.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    List<CategoryVO> getCategoryTree();

    int addOne(String name, String parentNo);

    int updateCategoryByCategoryNo(String categoryNo, String name, String parentNo);
}
