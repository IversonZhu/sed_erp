package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DepartmentMapper {

    @Insert("insert into (department_no,name,status) values (#{departmentNo},#{name},#{status}")
    int addOne(Department department);

    @Update("")
    int update();

    @Select("")
    List<Department> getList();
}
