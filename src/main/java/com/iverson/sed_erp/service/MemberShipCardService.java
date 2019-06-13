package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.MemberShipCardForm;
import com.iverson.sed_erp.pojo.MemberShipCard;

public interface MemberShipCardService {
    int addOne(MemberShipCardForm memberShipCardForm);

    PageInfo<MemberShipCard> getMemberShipCards(String cardNo, String holder, String phoneNumber, Integer type, int pageNum, int pageSize);

    int updateMemberShipCardByCardNo(MemberShipCardForm memberShipCardForm);
}
