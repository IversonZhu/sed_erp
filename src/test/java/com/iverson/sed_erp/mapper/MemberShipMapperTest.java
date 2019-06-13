package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.enums.MemberShipCardTypeEnum;
import com.iverson.sed_erp.pojo.MemberShipCard;
import com.iverson.sed_erp.util.NoGenerateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberShipMapperTest {

    @Autowired
    private MemberShipMapper memberShipMapper;

    @Test
    public void addOne() {
        MemberShipCard memberShipCard = new MemberShipCard();
        memberShipCard.setCardNo(NoGenerateUtil.getMemberShipCardNo());
        memberShipCard.setDiscount(80);
        memberShipCard.setHolder("Iverson");
        memberShipCard.setPhoneNumber("13822528774");
        memberShipCard.setType(MemberShipCardTypeEnum.DIAMOND.getCode());
        memberShipCard.setCreateTime(new Date());
        memberShipCard.setModifyTime(new Date());
        memberShipMapper.addOne(memberShipCard);
    }

    @Test
    public void searchMemberShipCardByCardNo() {
        List<MemberShipCard> memberShipCards = memberShipMapper.searchMemberShipCards(null,null,null,null);
        System.out.println(memberShipCards);
    }

    public void updateByCardNo(){
        MemberShipCard memberShipCard = new MemberShipCard();
        memberShipCard.setCardNo("");
        memberShipCard.setHolder("");
        memberShipCard.setPhoneNumber("");
        //memberShipCard.setDiscount();
        //memberShipCard.setType();
    }
}