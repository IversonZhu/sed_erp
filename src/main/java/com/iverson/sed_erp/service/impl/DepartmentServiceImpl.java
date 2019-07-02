package com.iverson.sed_erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.enums.DepartmentStatusEnum;
import com.iverson.sed_erp.form.DepartmentForm;
import com.iverson.sed_erp.mapper.DepartmentMapper;
import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.service.DepartmentService;
import com.iverson.sed_erp.util.NoGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        department.setStatus(departmentForm.getStatus());
        return departmentMapper.update(department);
    }

    @Override
    public PageInfo<Department> getList(String departmentNo, String name, Integer status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Department> departments = departmentMapper.getList(departmentNo,name,status);
        PageInfo<Department> departmentPageInfo = new PageInfo<>(departments);
        return departmentPageInfo;
    }
}
