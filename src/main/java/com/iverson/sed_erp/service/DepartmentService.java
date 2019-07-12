package com.iverson.sed_erp.service;

import com.iverson.sed_erp.form.DepartmentForm;
import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.vo.DepartmentVO;

import java.util.List;


public interface DepartmentService {

    int addOne(DepartmentForm departmentForm);

    int updateByNo(DepartmentForm departmentForm);

    List<DepartmentVO> getDepartmentTree();

    List<Department> getList();
}
