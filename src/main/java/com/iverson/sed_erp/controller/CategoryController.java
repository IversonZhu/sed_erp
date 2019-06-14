package com.iverson.sed_erp.controller;

import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.service.CategoryService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.CategoryVo;
import com.iverson.sed_erp.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/create")
    public ResultVo create(@RequestParam(name = "name") String name,
                           @RequestParam(name = "parentNo", required = false) String parentNo){
        int result = categoryService.addOne(name, parentNo);
        if(result == 1){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(), ResultEnum.INSERT_ERROR.getMessage());
    }

    @GetMapping("/update")
    public ResultVo update(@RequestParam(name = "categoryNo") String categoryNo,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "parentNo", required = false) String parentNo){
        int result = categoryService.updateCategoryByCategoryNo(categoryNo, name, parentNo);
        if(result == 1){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(), ResultEnum.UPDATE_ERROR.getMessage());
    }

    @GetMapping("/getTree")
    public ResultVo getCategoryTree(){
        List<CategoryVo> categories = categoryService.getCategoryTree();
        return ResultVoUtil.success(categories);
    }
}
