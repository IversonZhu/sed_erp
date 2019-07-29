package com.iverson.erp.mapper;

import com.iverson.erp.pojo.LogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/29
 */
@Mapper
@Component
public interface LogMapper {

    @Insert("insert into sed_market_log_info(client_ip,uri,type,method,param,token,return_data,http_status_code,time,return_time,time_consuming) " +
            "values(#{clientIp},#{uri},#{type},#{method},#{param},#{token},#{returnData},#{httpStatusCode},#{time},#{returnTime},#{timeConsuming})")
    void save(LogInfo logInfo);
}
