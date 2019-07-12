package com.iverson.erp.provider;

import com.iverson.erp.pojo.Department;
import org.apache.ibatis.annotations.Param;

public class DepartmentSqlProvider {

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
            sql.append("and department_no=#{departmentNo} ");
        }
        if(name != null) {
            sql.append("and name=#{name} ");
        }
        if(status != null){
            sql.append("and status=#{status} ");
        }
        if(parentDepartmentNo != null){
            sql.append("and parent_department_no=#{parentDepartmentNo}");
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
