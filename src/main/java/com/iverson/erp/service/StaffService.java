package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.vo.StaffVO;
import com.iverson.erp.form.StaffForm;

public interface StaffService {
    int addOne(StaffForm staffForm);

    int update(StaffForm staffForm);

    PageInfo<StaffVO> getList(String staffNo, String name, String phoneNumber, Integer sex, String birth, String departmentNo, int pageNum, int pageSize);
}
