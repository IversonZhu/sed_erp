package com.iverson.sed_erp.test;

import com.iverson.erp.dto.CartDTO;
import com.iverson.erp.pojo.Goods;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = "2019-06-13 12:00:00";
//        Date date = sdf.parse(time);
//        System.out.println(date);

//        Department department = new Department();
//        System.out.println("状态: " + department.getStatus());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birth = sdf.parse("1993-10-01");
//        System.out.println(birth.toString());

        CartDTO cartDTO = new CartDTO();
        cartDTO.setBarcode("123");
        cartDTO.setName("小明");
        cartDTO.setQuantity(111);
        cartDTO.setPrice(12.00);
        List<CartDTO> cartDTOS = new ArrayList<>();
        cartDTOS.add(cartDTO);
        if(cartDTO.getBarcode() .equals("123") ){
            cartDTO.setBarcode("456");
            cartDTOS.add(cartDTO);
        }
        System.out.println(cartDTOS.toString());
    }
}
