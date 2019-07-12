package com.iverson.erp.provider;

import com.iverson.erp.pojo.Staff;
import org.apache.ibatis.annotations.Param;

public class StaffSqlProvider {

    public String getUpdateSql(Staff staff){
        StringBuffer sql = new StringBuffer("update sed_market_staff set ");
        if(staff.getName() != null){
            sql.append("name=#{name},");
        }
        if(staff.getPhoneNumber() != null){
            sql.append("phone_number=#{phoneNumber},");
        }
        if(staff.getAge() != null){
            sql.append("age=#{age},");
        }
        if(staff.getSex() != null){
            sql.append("sex=#{sex},");
        }
        if(staff.getBirth() != null){
            sql.append("birth=#{birth},");
        }
        if(staff.getAddress() != null){
            sql.append("address=#{address},");
        }
        if(staff.getDepartmentNo() != null){
            sql.append("department_no=#{departmentNo},");
        }
        sql.replace(sql.length() - 1,sql.length(),"");
        sql.append(" where staff_no=#{staffNo}");
        return sql.toString();
    }

    public String getListSql(@Param("staffNo") String staffNo,
                             @Param("name") String name,
                             @Param("phoneNumber") String phoneNumber,
                             @Param("sex") Integer sex,
                             @Param("birth") String birth,
                             @Param("departmentNo") String departmentNo){
        String str = "select s.staff_no,s.name,s.phone_number,s.age,s.sex,s.birth,s.address,s.department_no,d.name as department_name from " +
                     "sed_market_staff s left join sed_market_department d on s.department_no = d.department_no where 1=1 ";
        StringBuffer sql = new StringBuffer(str);
        if(staffNo != null){
            sql.append("and s.staff_no like CONCAT('%',#{staffNo},'%') ");
        }
        if(name != null){
            sql.append("and s.name like CONCAT('%',#{name},'%') ");
        }
        if(phoneNumber != null){
            sql.append("and s.phone_number like CONCAT('%',#{phoneNumber},'%') ");
        }
        if(sex != null){
            sql.append("and s.sex like CONCAT('%',#{sex},'%') ");
        }
        if(birth != null){
            sql.append("and s.birth like CONCAT('%',#{birth},'%') ");
        }
        if(departmentNo != null){
            sql.append("and s.department_no like CONCAT('%',#{departmentNo},'%')");
        }
        return sql.toString();
    }
}
