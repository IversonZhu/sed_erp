package com.iverson.erp.mapper;

import com.iverson.erp.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/18
 */

@Mapper
@Component
public interface UserMapper {

    @Insert("insert into sed_market_user(user_no,role_no,user_name,nick_name,password) values(#{userNo},#{roleNo},#{userName},#{nickName},#{password})")
    int add(User user);


    int update();

    @Select("select * from sed_market_user where user_name=#{userName} and password=#{password}")
    User getByUP(@Param("userName") String userName,
                 @Param("password") String password);
}
