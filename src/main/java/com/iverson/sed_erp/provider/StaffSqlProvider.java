package com.iverson.sed_erp.provider;

import com.iverson.sed_erp.pojo.Staff;

public class StaffSqlProvider {

    public String getUpdateSql(Staff staff){
        StringBuffer sql = new StringBuffer("update sed_market_staff set ");
        if(staff.getName() != null){
            sql.append(" name=#{name},");
        }
        if(staff.getPhoneNumber() != null){
            sql.append(" phone_number=#{phoneNumber},");
        }
        if(staff.getAge() != null){
            sql.append(" age=#{age},");
        }
        if(staff.getSex() != null){
            sql.append(" sex=#{sex}");
        }
        if(staff.getBirth() != null){
            sql.append(" birth=#{birth}");
        }
        if(staff.getAddress() != null){
            sql.append(" address=#{address}");
        }
        if(staff.getDepartmentNo() != null){
            sql.append(" department_no=#{departmentNo}");
        }
        sql.append(" where staff_no=#{staffNo}");
        return sql.toString();
    }
}
