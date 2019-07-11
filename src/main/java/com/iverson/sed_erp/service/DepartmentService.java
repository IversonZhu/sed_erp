package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.DepartmentForm;
import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.vo.DepartmentVo;

import java.util.List;


public interface DepartmentService {

    int addOne(DepartmentForm departmentForm);

    int updateByNo(DepartmentForm departmentForm);

    List<DepartmentVo> getDepartmentTree();

    PageInfo<Department> getList(String departmentNo,String name, String parentDepartmentNo, Integer status,int pageNum, int pageSize);
}
