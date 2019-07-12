package com.iverson.erp.provider;

import org.apache.ibatis.annotations.Param;

public class CategorySqlProvider {

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
