package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.DepartmentForm;
import com.iverson.sed_erp.pojo.Department;


public interface DepartmentService {

    int addOne(DepartmentForm departmentForm);

    int updateByNo(DepartmentForm departmentForm);

    PageInfo<Department> getList(String departmentNo,String name,Integer status,int pageNum, int pageSize);
}
