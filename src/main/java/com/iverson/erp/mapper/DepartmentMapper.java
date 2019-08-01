package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Department;
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

    class DepartmentSqlProvider {
        /**
         * 获取列表sql
         * @param departmentNo
         * @param name
         * @return
         */
        public String getListSql(@Param("departmentNo") String departmentNo,
                                 @Param("name") String name,
                                 @Param("status") Integer status,
                                 @Param("parentDepartmentNo") String parentDepartmentNo){
            StringBuffer sql = new StringBuffer("select * from sed_market_department where 1=1 ");
            if(departmentNo != null){
                sql.append("and department_no like CONCAT('%',#{departmentNo},'%') ");
            }
            if(name != null) {
                sql.append("and name like CONCAT('%',#{name},'%') ");
            }
            if(status != null){
                sql.append("and status=#{status} ");
            }
            if(parentDepartmentNo != null){
                sql.append("and parent_department_no like CONCAT('%',#{parentDepartmentNo},'%')");
            }
            return sql.toString();
        }

        /**
         * 获取更新sql语句
         * @param department
         * @return
         */
        public String getUpdateSql(Department department){
            StringBuffer sql = new StringBuffer("update sed_market_department set ");
            if(department.getName() != null){
                sql.append("name=#{name},");
            }
            if(department.getStatus() != null){
                sql.append("status=#{status},");
            }
            if(department.getParentDepartmentNo() != null){
                sql.append("parent_department_no=#{parentDepartmentNo},");
            }
            sql.replace(sql.length() - 1,sql.length()," ");
            sql.append("where department_no=#{departmentNo}");
            return sql.toString();
        }
    }
}
