package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.enums.DepartmentStatusEnum;
import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.util.NoGenerateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void addOne() {
        Department department = new Department();
        department.setDepartmentNo(NoGenerateUtil.getDepartmentNo());
        department.setName("软件开发部");
        department.setStatus(DepartmentStatusEnum.NORMAL.getCode());
        int result = departmentMapper.addOne(department);
        System.out.println("结果: " + result);
    }

    @Test
    public void update() {
    }

    @Test
    public void getList() {
    }
}