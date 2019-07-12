package com.iverson.sed_erp.service.impl;

import com.iverson.sed_erp.mapper.CategoryMapper;
import com.iverson.sed_erp.pojo.Category;
import com.iverson.sed_erp.service.CategoryService;
import com.iverson.sed_erp.util.NoGenerateUtil;
import com.iverson.sed_erp.vo.CategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> getCategoryTree() {
        List<Category> allCategory = categoryMapper.getAll();
        List<CategoryVO> rootCategory = new ArrayList<>();
        for(Category category : allCategory){
            CategoryVO categoryVo = new CategoryVO();
            BeanUtils.copyProperties(category,categoryVo);
            if(categoryVo.getParentNo() == null){
                rootCategory.add(categoryVo);
            }
        }
        for(CategoryVO categoryVo : rootCategory){
            List<CategoryVO> childList = getChild(categoryVo.getCategoryNo(), allCategory);
            categoryVo.setCategorys(childList);
        }
        return rootCategory;
    }

    @Override
    @Transactional
    public int addOne(String name, String parentNo) {
        return categoryMapper.addOne(NoGenerateUtil.getCategoryNo(), name, parentNo, new Date(), new Date());
    }

    @Override
    @Transactional
    public int updateCategoryByCategoryNo(String categoryNo, String name, String parentNo) {
        return categoryMapper.update(categoryNo, name, parentNo, new Date());
    }

    /**
     * 获取子菜单
     * @param categoryNo
     * @param allCategory
     * @return
     */
    private List<CategoryVO> getChild(String categoryNo, List<Category> allCategory) {
        List<CategoryVO> childList = new ArrayList<>();
        for(Category category : allCategory){
            CategoryVO categoryVo = new CategoryVO();
            BeanUtils.copyProperties(category,categoryVo);
            if(categoryVo.getParentNo() != null && categoryVo.getParentNo().equals(categoryNo)){
                childList.add(categoryVo);
            }
        }
        //递归
        for (CategoryVO categoryVo : childList) {
            categoryVo.setCategorys(getChild(categoryVo.getCategoryNo(), allCategory));
        }
        if(childList.size() == 0){
            return new ArrayList<CategoryVO>();
        }
        return childList;
    }
}
