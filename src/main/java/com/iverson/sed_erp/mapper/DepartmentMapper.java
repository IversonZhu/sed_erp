package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.provider.DepartmentSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DepartmentMapper {

    @Insert("insert into sed_market_department (department_no,name,status) values (#{departmentNo},#{name},#{status})")
    int addOne(Department department);

    @UpdateProvider(type = DepartmentSqlProvider.class, method = "getUpdateSql")
    int update(Department department);

    @SelectProvider(type = DepartmentSqlProvider.class, method = "getListSql")
    List<Department> getList(@Param("departmentNo") String departmentNo,
                             @Param("name") String name,
                             @Param("status") int status);
}
