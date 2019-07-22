package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Module;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/22
 */
@Mapper
@Component
public interface ModuleMapper {

    @Insert("insert into sed_market_module(no,parent_no,title,icon,path,page) values(#{no},#{parentNo},#{title},#{icon},#{path},#{page})")
    int add(Module module);

    @Update("update sed_market_module set title=#{title}, icon=#{icon} , path=#{path} ,page=#{page} where no=#{no}")
    int update(Module module);

    @Select("select * from sed_market_module")
    List<Module> getAll();
}
