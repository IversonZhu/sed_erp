package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Brand;
import com.iverson.erp.vo.BrandVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BrandMapper {

    @Insert("insert into sed_market_brand(brand_no,name,status) values(#{brandNo},#{name},#{status})")
    int addOne(Brand brand);

    @SelectProvider(type = BrandSqlProvider.class, method = "getListSql")
    List<Brand> getList(@Param("brandNo") String brandNo,
                        @Param("name") String name,
                        @Param("status") Integer status);

    @UpdateProvider(type = BrandSqlProvider.class, method = "getUpdateSql")
    int update(Brand brand);



    @Select("select brand_no, name from sed_market_brand where status=#{status}")
    List<BrandVO> getAll(Integer status);

    class BrandSqlProvider{
        public String getListSql(@Param("brandNo") String brandNo,
                          @Param("name") String name,
                          @Param("status") Integer status){
            StringBuffer sql = new StringBuffer("select * from sed_market_brand where 1=1");
            if(brandNo != null){
                sql.append(" and brand_no like CONCAT('%',#{brandNo},'%')");
            }
            if(name != null){
                sql.append(" and name like CONCAT('%',#{name},'%')");
            }
            if(status != null){
                sql.append(" and status=#{status}");
            }
            return sql.toString();
        }

        public String getUpdateSql(Brand brand){
            StringBuffer sql = new StringBuffer("update sed_market_brand set ");
            if(brand.getName() != null){
                sql.append("name=#{name},");
            }
            if(brand.getStatus() != null){
                sql.append("status=#{status},");
            }
            sql.replace(sql.length() - 1,sql.length()," ");
            sql.append("where brand_no=#{brandNo}");
            return sql.toString();
        }
    }
}
