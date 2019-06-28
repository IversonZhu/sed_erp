package com.iverson.sed_erp.provider;

import org.apache.ibatis.annotations.Param;

public class CategorySqlProvider {

    public String getInsertSql(@Param("parentNo") String parentNo){
        StringBuffer sql = new StringBuffer("insert into sed_market_category");
        if(parentNo != null) {
            sql.append(" (category_no, name, parent_no, create_time, modify_time) values(#{categoryNo}, #{name}, #{parentNo}, #{createTime}, #{modifyTime})");
            return sql.toString();
        }
        sql.append(" (category_no, name, create_time, modify_time) values(#{categoryNo}, #{name}, #{createTime}, #{modifyTime})");
        return sql.toString();
    }
}
