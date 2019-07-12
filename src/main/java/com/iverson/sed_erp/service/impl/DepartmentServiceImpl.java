package com.iverson.sed_erp.service.impl;

import com.iverson.sed_erp.enums.DepartmentStatusEnum;
import com.iverson.sed_erp.form.DepartmentForm;
import com.iverson.sed_erp.mapper.DepartmentMapper;
import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.service.DepartmentService;
import com.iverson.sed_erp.util.NoGenerateUtil;
import com.iverson.sed_erp.vo.DepartmentVO;
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
    public List<DepartmentVO> getDepartmentTree(){
        List<Department> allDepartment = departmentMapper.getAll();
        List<DepartmentVO> rootDepartmentVo = new ArrayList<>();
        for(Department department : allDepartment) {
            DepartmentVO departmentVo = new DepartmentVO();
            BeanUtils.copyProperties(department, departmentVo);
            if (department.getParentDepartmentNo() == null) {
                rootDepartmentVo.add(departmentVo);
            }
        }
        for(DepartmentVO departmentVo : rootDepartmentVo){
            List<DepartmentVO> childList = getChild(departmentVo.getDepartmentNo(), allDepartment);
            departmentVo.setDepartments(childList);
        }
        return rootDepartmentVo;
    }

    @Override
    public List<Department> getList() {
        List<Department> departments = departmentMapper.getAll();
        return departments;
    }

    /**
     * 获取子部门
     * @param departmentNo
     * @param allDepartment
     * @return
     */
    private List<DepartmentVO> getChild(String departmentNo, List<Department> allDepartment) {
        List<DepartmentVO> childList = new ArrayList<>();
        for(Department department : allDepartment){
            DepartmentVO departmentVo = new DepartmentVO();
            BeanUtils.copyProperties(department,departmentVo);
            if(departmentVo.getParentDepartmentNo() != null && departmentVo.getParentDepartmentNo().equals(departmentNo)){
                childList.add(departmentVo);
            }
        }
        //递归
        for (DepartmentVO departmentVo : childList) {
            departmentVo.setDepartments(getChild(departmentVo.getDepartmentNo(), allDepartment));
        }
        if(childList.size() == 0){
            return new ArrayList<DepartmentVO>();
        }
        return childList;
    }
}
