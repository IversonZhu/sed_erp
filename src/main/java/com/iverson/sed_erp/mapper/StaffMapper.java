package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Staff;
import com.iverson.sed_erp.provider.StaffSqlProvider;
import com.iverson.sed_erp.vo.StaffVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface StaffMapper {

    @Insert("insert into sed_market_staff (staff_no,name,phone_number,age,sex,birth,address,department_no) values " +
            "(#{staffNo},#{name},#{phoneNumber},#{age},#{sex},#{birth},#{address},#{departmentNo})")
    int addOne(Staff staff);

    @UpdateProvider(type = StaffSqlProvider.class, method = "getUpdateSql")
    int update(Staff staff);

    @SelectProvider(type = StaffSqlProvider.class, method = "getListSql")
    List<StaffVo> getList(@Param("staffNo") String staffNo,
                          @Param("name") String name,
                          @Param("phoneNumber") String phoneNumber,
                          @Param("sex") Integer sex,
                          @Param("birth") Date birth,
                          @Param("address") String address,
                          @Param("departmentNo") String departmentNo);
}
