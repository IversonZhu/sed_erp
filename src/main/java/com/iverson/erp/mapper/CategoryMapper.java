package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Category;
import com.iverson.erp.provider.CategorySqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface CategoryMapper {

    @InsertProvider(type = CategorySqlProvider.class, method = "getInsertSql")
    int addOne(@Param("categoryNo") String categoryNo,
               @Param("name") String name,
               @Param("parentNo") String parentNo,
               @Param("createTime") Date createTime,
               @Param("modifyTime") Date modifyTime);

    @Update("update sed_market_category set name=#{name}, parent_no=#{parentNo}, modify_time=#{modifyTime} where category_no=#{categoryNo}")
    int update(@Param("categoryNo") String categoryNo,
               @Param("name") String name,
               @Param("parentNo") String parentNo,
               @Param("modifyTime") Date modifyTime);

    @Select("select * from sed_market_category")
    List<Category> getAll();
}
