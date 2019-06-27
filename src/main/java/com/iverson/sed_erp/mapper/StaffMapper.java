package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StaffMapper {

    /**
     * 添加员工
     * @param staff
     * @return
     */
    @Insert("insert into sed_market_staff values " +
            "(#{id},#{staffNo},#{name},#{phoneNumber},#{age},#{sex},#{birth},#{address},#{departmentNo},#{departmentName},#{createTime},#{modifyTime})")
    int addOne(Staff staff);
}
