package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Department;
import com.iverson.erp.provider.DepartmentSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DepartmentMapper {

    @Insert("insert into sed_market_department (department_no,name,status,parent_department_no) values (#{departmentNo},#{name},#{status},#{parentDepartmentNo})")
    int addOne(Department department);

    @UpdateProvider(type = DepartmentSqlProvider.class, method = "getUpdateSql")
    int update(Department department);

    @SelectProvider(type = DepartmentSqlProvider.class, method = "getListSql")
    List<Department> getList(@Param("departmentNo") String departmentNo,
                             @Param("name") String name,
                             @Param("parentDepartmentNo") String parentDepartmentNo,
                             @Param("status") Integer status);

    @Select("select * from sed_market_department")
    List<Department> getAll();
}
