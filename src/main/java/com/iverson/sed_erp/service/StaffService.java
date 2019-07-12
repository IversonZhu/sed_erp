package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.StaffForm;
import com.iverson.sed_erp.vo.StaffVO;

public interface StaffService {
    int addOne(StaffForm staffForm);

    int update(StaffForm staffForm);

    PageInfo<StaffVO> getList(String staffNo, String name, String phoneNumber, Integer sex, String birth, String departmentNo, int pageNum, int pageSize);
}
