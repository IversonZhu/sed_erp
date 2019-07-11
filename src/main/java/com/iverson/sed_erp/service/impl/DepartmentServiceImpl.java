package com.iverson.sed_erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.DepartmentStatusEnum;
import com.iverson.sed_erp.form.DepartmentForm;
import com.iverson.sed_erp.mapper.DepartmentMapper;
import com.iverson.sed_erp.pojo.Category;
import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.service.DepartmentService;
import com.iverson.sed_erp.util.NoGenerateUtil;
import com.iverson.sed_erp.vo.CategoryVo;
import com.iverson.sed_erp.vo.DepartmentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    @Transactional
    public int addOne(DepartmentForm departmentForm){
        Department department = new Department();
        department.setDepartmentNo(NoGenerateUtil.getDepartmentNo());
        department.setName(departmentForm.getName());
        department.setParentDepartmentNo(departmentForm.getParentDepartmentNo());
        department.setStatus(DepartmentStatusEnum.NORMAL.getCode());
        return departmentMapper.addOne(department);
    }

    @Override
    @Transactional
    public int updateByNo(DepartmentForm departmentForm){
        if(departmentForm.getDepartmentNo() == null)
            return 0;
        Department department = new Department();
        department.setDepartmentNo(departmentForm.getDepartmentNo());
        department.setName(departmentForm.getName());
        department.setParentDepartmentNo(departmentForm.getParentDepartmentNo());
        department.setStatus(departmentForm.getStatus());
        return departmentMapper.update(department);
    }

    @Override
    public List<DepartmentVo> getDepartmentTree(){
        List<Department> allDepartment = departmentMapper.getAll();
        List<DepartmentVo> rootDepartmentVo = new ArrayList<>();
        for(Department department : allDepartment) {
            DepartmentVo departmentVo = new DepartmentVo();
            BeanUtils.copyProperties(department, departmentVo);
            if (department.getParentDepartmentNo() == null) {
                rootDepartmentVo.add(departmentVo);
            }
        }
        for(DepartmentVo departmentVo : rootDepartmentVo){
            List<DepartmentVo> childList = getChild(departmentVo.getDepartmentNo(), allDepartment);
            departmentVo.setDepartments(childList);
        }
        return rootDepartmentVo;
    }

    @Override
    public PageInfo<Department> getList(String departmentNo, String name, String parentDepartmentNo, Integer status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Department> departments = departmentMapper.getList(departmentNo,name,parentDepartmentNo,status);
        PageInfo<Department> departmentPageInfo = new PageInfo<>(departments);
        return departmentPageInfo;
    }

    /**
     * 获取子部门
     * @param departmentNo
     * @param allDepartment
     * @return
     */
    private List<DepartmentVo> getChild(String departmentNo, List<Department> allDepartment) {
        List<DepartmentVo> childList = new ArrayList<>();
        for(Department department : allDepartment){
            DepartmentVo departmentVo = new DepartmentVo();
            BeanUtils.copyProperties(department,departmentVo);
            if(departmentVo.getParentDepartmentNo() != null && departmentVo.getParentDepartmentNo().equals(departmentNo)){
                childList.add(departmentVo);
            }
        }
        //递归
        for (DepartmentVo departmentVo : childList) {
            departmentVo.setDepartments(getChild(departmentVo.getDepartmentNo(), allDepartment));
        }
        if(childList.size() == 0){
            return new ArrayList<DepartmentVo>();
        }
        return childList;
    }
}
