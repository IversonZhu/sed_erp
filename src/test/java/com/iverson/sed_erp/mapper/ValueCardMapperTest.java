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
        ValueCard valueCard = valueCardMapper.searchValueCardByCardNo("vcn20190611140042788866");
        Assert.assertNotNull(valueCard);
    }
}