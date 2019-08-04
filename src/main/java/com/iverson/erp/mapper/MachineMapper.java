package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Machine;
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
public interface MachineMapper {

    @Insert("insert into sed_market_machine (machine_no,shop_no,serial_number,machine_name,machine_token) " +
            "values(#{machineNo},#{shopNo},#{serialNumber},#{machineName},#{machineToken})")
    int add(Machine machine);

    @Select("select * from sed_market_machine where shop_no=#{shopNo}")
    List<Machine> getByNo(@Param("shopNo") String shopNo);

    @Delete("delete from sed_market_machine where machine_no=#{machineNo} and shop_no=#{shopNo}")
    int delete(@Param("machineNo") String machineNo, @Param("shopNo") String shopNo);

    @UpdateProvider(type = MachineSqlProvider.class, method = "getUpdateSql")
    int update(Machine machine);

    @Select("select * from sed_market_machine where shop_no=#{shopNo}")
    List<Machine> getListByShopNo(String shopNo);

    class MachineSqlProvider{
        public String getUpdateSql(Machine machine){
            StringBuffer sql = new StringBuffer("update sed_market_machine set ");
            if(!StringUtils.isEmpty(machine.getMachineName())){
                sql.append("machine_name=#{machineName},");
            }
            if(!StringUtils.isEmpty(machine.getSerialNumber())){
                sql.append("serial_number=#{serialNumber},");
            }
            sql.replace(sql.length() - 1,sql.length()," ");
            sql.append("where machine_no=#{machineNo} and shop_no=#{shopNo}");
            return sql.toString();
        }
    }
}
