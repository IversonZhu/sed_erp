package com.iverson.erp.mapper;

import com.iverson.erp.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Insert("insert into sed_market_user(user_no,role_no,user_name,nick_name,password,status) values(#{userNo},#{roleNo},#{userName},#{nickName},#{password},#{status})")
    int add(User user);

    @Update("update sed_market_user set role_no=#{roleNo},user_name=#{userName},nick_name=#{nickName},password=#{password},status=#{status} where user_no=#{userNo}")
    int update(User user);

    @Select("select * from sed_market_user where user_name=#{userName} and password=#{password} and status=0")
    User getByUP(@Param("userName") String userName,
                 @Param("password") String password);

    @SelectProvider(type = UserSqlProvider.class, method = "getListSql")
    List<User> getList(@Param("userNo") String userNo, @Param("roleNo") String roleNo, @Param("userName") String userName, @Param("nickName") String nickName);

    class UserSqlProvider {
        public String getListSql(@Param("userNo") String userNo, @Param("roleNo") String roleNo, @Param("userName") String userName, @Param("nickName") String nickName){
            StringBuffer sql = new StringBuffer("select * from sed_market_user where 1=1");
            if(!StringUtils.isEmpty(userNo)){
                sql.append("and user_no like CONCAT('%',#{userNo},'%') ");
            }
            if(!StringUtils.isEmpty(roleNo)){
                sql.append("and role_no=#{roleNo} ");
            }
            if(!StringUtils.isEmpty(userName)){
                sql.append("and user_name like CONCAT('%',#{userName},'%') ");
            }
            if(!StringUtils.isEmpty(nickName)){
                sql.append("and nick_name like CONCAT('%',#{nickName},'%') ");
            }
            return sql.toString();
        }
    }
}
