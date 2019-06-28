package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Staff;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Mapper
public interface StaffMapper {

    @Insert("insert into sed_market_staff (staff_no,name,phone_number,age,sex,birth,address,department_no) values " +
            "(#{staffNo},#{name},#{phoneNumber},#{age},#{sex},#{birth},#{address},#{departmentNo})")
    int addOne(Staff staff);
//    int addOne(@Param("staffNo") String staffNo, @Param("name") String name, @Param("phoneNumber") String phoneNumber, @Param("age") int age,
//               @Param("sex") int sex, @Param("birth")Date birth, @Param("address") String address, @Param("departmentNo") String departmentNo);

    @Update("<script> update sed_market_staff " +
            "<trim prefix=\\\"set\\\" suffixOverrides=\\\",\\\"> " +
            "<if test=\"staff.\">")
    int update(Staff staff);
}
