package com.iverson.erp.service;

import com.iverson.erp.pojo.Department;
import com.iverson.erp.vo.DepartmentVO;
import com.iverson.erp.form.DepartmentForm;

import java.util.List;


public interface DepartmentService {

    int addOne(DepartmentForm departmentForm);

    int updateByNo(DepartmentForm departmentForm);

    List<DepartmentVO> getDepartmentTree();

    List<Department> getList();
}
