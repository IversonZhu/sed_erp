package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Category;
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

    class CategorySqlProvider {
        public String getInsertSql(@Param("parentNo") String parentNo){
            StringBuffer sql = new StringBuffer("insert into sed_market_category");
            if(parentNo != null) {
                sql.append(" (category_no, name, parent_no) values(#{categoryNo}, #{name}, #{parentNo})");
                return sql.toString();
            }
            sql.append(" (category_no, name) values(#{categoryNo}, #{name})");
            return sql.toString();
        }
    }
}
