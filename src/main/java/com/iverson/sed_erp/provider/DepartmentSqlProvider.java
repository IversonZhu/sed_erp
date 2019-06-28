package com.iverson.sed_erp.provider;

import com.iverson.sed_erp.pojo.Department;
import org.apache.ibatis.annotations.Param;

public class DepartmentSqlProvider {

    /**
     * 获取列表sql
     * @param departmentNo
     * @param name
     * @return
     */
    public String getListSql(@Param("departmentNo") String departmentNo,
                             @Param("name") String name){
        StringBuffer sql = new StringBuffer("select * from sed_market_department where 1=1 ");
        if(departmentNo != null){
            sql.append("and department_no=#{departmentNo} ");
        }
        if(name != null) {
            sql.append("and name=#{name} ");
        }
        sql.append("and status=#{status}");
        return sql.toString();
    }

    /**
     * 获取更新sql语句
     * @param department
     * @return
     */
    public String getUpdateSql(Department department){
        StringBuffer sql = new StringBuffer("update sed_market_department set status=#{status} ");
        if(department.getName() != null){
            sql.append(",name=#{name} ");
        }
        sql.append("where department_no=#{departmentNo}");
        return sql.toString();
    }
}
