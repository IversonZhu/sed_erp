package com.iverson.sed_erp.exception;

import com.iverson.sed_erp.enums.ResultEnum;

public class MarketException extends RuntimeException{
    private Integer code;

    public MarketException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
