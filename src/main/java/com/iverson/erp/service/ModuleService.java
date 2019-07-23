package com.iverson.erp.service;

import com.iverson.erp.form.ModuleForm;
import com.iverson.erp.pojo.Module;
import com.iverson.erp.vo.ModuleVO;

import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/22
 */
public interface ModuleService {
    int add(ModuleForm moduleForm);

    int update(ModuleForm moduleForm);

    List<ModuleVO> getTree();

}
