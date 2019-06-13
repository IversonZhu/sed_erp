package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.ValueCard;
import com.iverson.sed_erp.util.NoGenerateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueCardMapperTest {

    @Autowired
    private ValueCardMapper valueCardMapper;

    @Test
    public void addOne() {
        ValueCard valueCard = new ValueCard();
        valueCard.setCardNo(NoGenerateUtil.getValueCardNo());
        valueCard.setHolder("Curry");
        valueCard.setBalance(200.00);
        valueCard.setPhoneNumber("13822528775");
        valueCard.setCreateTime(new Date());
        valueCard.setModifyTime(new Date());
        int i = valueCardMapper.addOne(valueCard);
    }

    @Test
    public void searchMemberShipCardByCardNo() {
        List<ValueCard> valueCard = valueCardMapper.searchValueCards("vcn20190612163704196125","Iverson",null);
        Assert.assertNotNull(valueCard);
    }

    @Test
    public void updateByCardNo(){
        ValueCard valueCard = new ValueCard();
        valueCard.setCardNo("vcn20190612163704196125");
        valueCard.setHolder("Iverson");
        valueCard.setBalance(99.51);
        valueCard.setPhoneNumber("13822528774");
        valueCard.setModifyTime(new Date());
        int result = valueCardMapper.updateByCardNo(valueCard);
        System.out.println("执行成功: " + result);
    }
}