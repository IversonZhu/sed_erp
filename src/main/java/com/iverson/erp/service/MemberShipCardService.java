package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.MemberShipCardForm;
import com.iverson.erp.pojo.MemberShipCard;

public interface MemberShipCardService {
    int addOne(MemberShipCardForm memberShipCardForm);

    PageInfo<MemberShipCard> getMemberShipCards(String cardNo, String holder, String phoneNumber, Integer type, int pageNum, int pageSize);

    int updateMemberShipCardByCardNo(MemberShipCardForm memberShipCardForm);
}
