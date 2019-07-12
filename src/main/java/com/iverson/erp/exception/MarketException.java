package com.iverson.erp.exception;

import com.iverson.erp.enums.ResultEnum;

public class MarketException extends RuntimeException{
    private Integer code;

    public MarketException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
