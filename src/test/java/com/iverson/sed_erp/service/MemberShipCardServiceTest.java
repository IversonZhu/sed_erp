package com.iverson.sed_erp.service;

import com.iverson.sed_erp.form.MemberShipCardForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberShipCardServiceTest {

    @Autowired
    private MemberShipCardService memberShipCardService;

    @Test
    public void updateMemberShipCardByCardNo() {
        MemberShipCardForm memberShipCardForm = new MemberShipCardForm();
        memberShipCardForm.setCardNo("mscn20190611135010687904");
        memberShipCardForm.setHolder("朱华耀");
        int result = memberShipCardService.updateMemberShipCardByCardNo(memberShipCardForm);
        System.out.println("输出结果: " + result);
    }
}