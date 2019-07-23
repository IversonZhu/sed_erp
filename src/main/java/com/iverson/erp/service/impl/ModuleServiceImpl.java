package com.iverson.erp.service.impl;

import com.iverson.erp.form.ModuleForm;
import com.iverson.erp.mapper.ModuleMapper;
import com.iverson.erp.pojo.Module;
import com.iverson.erp.service.ModuleService;
import com.iverson.erp.util.NoGenerateUtil;
import com.iverson.erp.vo.ModuleVO;
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
    public List<ModuleVO> getTree() {
        List<Module> allModule = moduleMapper.getAll();
        List<ModuleVO> rootModule = new ArrayList<>();
        for (Module module : allModule) {
            ModuleVO moduleVO = new ModuleVO();
            BeanUtils.copyProperties(module,moduleVO);
            if (moduleVO.getParentNo() == null) {
                rootModule.add(moduleVO);
            }
        }
        for (ModuleVO moduleVO : rootModule) {
            List<ModuleVO> childList = getChild(moduleVO.getNo(),allModule);
            moduleVO.setModuleVOS(childList);
        }
        return rootModule;
    }

    private List<ModuleVO> getChild(String no, List<Module> allModule) {
        List<ModuleVO> childList = new ArrayList<>();
        for (Module module : allModule) {
            ModuleVO moduleVO = new ModuleVO();
            BeanUtils.copyProperties(module,moduleVO);
            if (moduleVO.getParentNo() != null && moduleVO.getParentNo().equals(no)) {
                childList.add(moduleVO);
            }
        }
        //递归
        for (ModuleVO moduleVO : childList) {
            moduleVO.setModuleVOS(getChild(moduleVO.getNo(),allModule));
        }
        if (childList.size() == 0) {
            return new ArrayList<ModuleVO>();
        }
        return childList;
    }
}
