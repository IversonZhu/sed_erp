package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DepartmentMapper {

    @Insert("insert into (department_no,name,status) values (#{departmentNo},#{name},#{status}")
    int addOne(Department department);
}
