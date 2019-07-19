package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Role;
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
public interface RoleMapper {

    @Insert("insert into sed_market_role(role_no,role_name,status,module) values(#{roleNo},#{roleName},#{status},#{module})")
    int add(Role role);

    @UpdateProvider(type = RoleSqlProvider.class, method = "getUpdateSql")
    int update(Role role);

    @SelectProvider(type = RoleSqlProvider.class, method = "getListSql")
    List<Role> getList(@Param("roleNo") String roleNo,
                       @Param("roleName") String roleName);

    @Select("select role_name from sed_market_role where role_no=#{roleNo}")
    String getRoleNameByNo(String roleNo);

    class RoleSqlProvider {

        public String getUpdateSql(Role role){
            StringBuffer sql = new StringBuffer("update sed_market_role set status=#{status},");
            if(!StringUtils.isEmpty(role.getRoleName())){
                sql.append("role_name=#{roleName},");
            }
            sql.replace(sql.length() - 1,sql.length()," ");
            sql.append("where role_no=#{roleNo}");
            return sql.toString();
        }

        public String getListSql(@Param("roleNo") String roleNo,
                                 @Param("roleName") String roleName) {
            StringBuffer sql = new StringBuffer("select * from sed_market_role where 1=1 ");
            if(!StringUtils.isEmpty(roleNo)){
                sql.append("and role_no like CONCAT('%',#{roleNo},'%') ");
            }
            if(!StringUtils.isEmpty(roleName)){
                sql.append("and role_name like CONCAT('%',#{roleName},'%') ");
            }
            return sql.toString();
        }
    }
}
