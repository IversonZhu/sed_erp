package com.iverson.erp.vo;

import com.iverson.erp.dto.CartDTO;
import lombok.Data;

import java.util.List;

@Data
public class CartVO {
    private String key;
    private List<CartDTO> cartDTOS;
}
