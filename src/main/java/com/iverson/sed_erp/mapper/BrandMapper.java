package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Brand;
import com.iverson.sed_erp.provider.BrandSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BrandMapper {

    @Insert("insert into sed_market_brand values(#{id},#{brandNo},#{name},#{status},#{createTime},#{modifyTime})")
    int addOne(Brand brand);

    @SelectProvider(type = BrandSqlProvider.class, method = "getListSql")
    List<Brand> getList(@Param("brandNo") String brandNo,
                          @Param("name") String name);

    @UpdateProvider(type = BrandSqlProvider.class, method = "getUpdateSql")
    int update(Brand brand);
}
