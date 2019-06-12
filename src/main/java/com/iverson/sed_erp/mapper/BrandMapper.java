package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.Brand;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BrandMapper {

    @Insert("insert into sed_market_brand values(#{id},#{brandNo},#{name},#{createTime},#{modifyTime})")
    void addBrand(Brand brand);

    @Select("select * from sed_market_brand where brand_no = #{brandNo}")
    Brand getBrandByBrandNo(String brandNo);

    @Select("select * from sed_market_brand")
    List<Brand> getList();
}
