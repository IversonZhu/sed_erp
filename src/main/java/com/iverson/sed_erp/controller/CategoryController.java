package com.iverson.sed_erp.controller;

import com.iverson.sed_erp.enums.ResultEnum;
import com.iverson.sed_erp.service.CategoryService;
import com.iverson.sed_erp.util.ResultVoUtil;
import com.iverson.sed_erp.vo.CategoryVO;
import com.iverson.sed_erp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/create")
    public ResultVO create(@RequestParam(name = "name") String name,
                           @RequestParam(name = "parentNo", required = false) String parentNo){
        int result = categoryService.addOne(name, parentNo);
        if(result == 1){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error(ResultEnum.INSERT_ERROR.getCode(), ResultEnum.INSERT_ERROR.getMessage());
    }

    @GetMapping("/update")
    public ResultVO update(@RequestParam(name = "categoryNo") String categoryNo,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "parentNo") String parentNo){
        int result = categoryService.updateCategoryByCategoryNo(categoryNo, name, parentNo);
        if(result == 1){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error(ResultEnum.UPDATE_ERROR.getCode(), ResultEnum.UPDATE_ERROR.getMessage());
    }

    @GetMapping("/getTree")
    public ResultVO getCategoryTree(){List<CategoryVO> categories = categoryService.getCategoryTree();
        return ResultVoUtil.success(categories);

    }
}
