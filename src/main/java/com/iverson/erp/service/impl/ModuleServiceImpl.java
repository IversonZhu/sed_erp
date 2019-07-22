package com.iverson.erp.service.impl;

import com.iverson.erp.form.ModuleForm;
import com.iverson.erp.mapper.ModuleMapper;
import com.iverson.erp.pojo.Module;
import com.iverson.erp.service.ModuleService;
import com.iverson.erp.util.NoGenerateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/22
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public int add(ModuleForm moduleForm) {
        Module module = new Module();
        module.setNo(NoGenerateUtil.getModuleNo());
        module.setParentNo(moduleForm.getParentNo());
        module.setTitle(moduleForm.getTitle());
        module.setIcon(moduleForm.getIcon());
        module.setPath(moduleForm.getPath());
        module.setPage(moduleForm.getPage());
        return moduleMapper.add(module);
    }

    @Override
    public int update(ModuleForm moduleForm) {
        Module module = new Module();
        module.setNo(moduleForm.getNo());
        module.setParentNo(moduleForm.getParentNo());
        module.setTitle(moduleForm.getTitle());
        module.setIcon(moduleForm.getIcon());
        module.setPath(moduleForm.getPath());
        module.setPage(moduleForm.getPage());
        return moduleMapper.update(module);
    }

    @Override
    public List<Module> getTree() {
        List<Module> allModule = moduleMapper.getAll();
        List<Module> rootModule = new ArrayList<>();
        for (Module module : allModule) {
            Module temp = new Module();
            BeanUtils.copyProperties(module,temp);
            if (temp.getParentNo() == null) {
                rootModule.add(module);
            }
        }
//        for (Module module : rootModule) {
//            List<Module> childList = getChild(module.getNo(),allModule);
//            module.set
//        }
        return rootModule;
    }
}
