package com.iverson.sed_erp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMasterMapper {

    int addOne();

    int update();
}
