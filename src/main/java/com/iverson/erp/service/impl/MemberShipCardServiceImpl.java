package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.MemberShipCardForm;
import com.iverson.erp.mapper.MemberShipMapper;
import com.iverson.erp.pojo.MemberShipCard;
import com.iverson.erp.util.NoGenerateUtil;
import com.iverson.erp.service.MemberShipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberShipCardServiceImpl implements MemberShipCardService {

    @Autowired
    private MemberShipMapper memberShipMapper;

    @Override
    @Transactional
    public int addOne(MemberShipCardForm memberShipCardForm) {
        MemberShipCard memberShipCard = new MemberShipCard();
        memberShipCard.setCardNo(NoGenerateUtil.getMemberShipCardNo());
        memberShipCard.setHolder(memberShipCardForm.getHolder());
        memberShipCard.setPhoneNumber(memberShipCardForm.getPhoneNumber());
        memberShipCard.setType(memberShipCardForm.getType());
        memberShipCard.setDiscount(memberShipCardForm.getDiscount());
        return memberShipMapper.addOne(memberShipCard);
    }

    @Override
    public PageInfo<MemberShipCard> getMemberShipCards(String cardNo, String holder, String phoneNumber, Integer  type, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<MemberShipCard> memberShipCards = memberShipMapper.getList(cardNo, holder, phoneNumber, type);
        PageInfo<MemberShipCard> memberShipCardPageInfo = new PageInfo<>(memberShipCards);
        return memberShipCardPageInfo;
    }

    @Override
    @Transactional
    public int updateMemberShipCardByCardNo(MemberShipCardForm memberShipCardForm) {
        if(memberShipCardForm.getCardNo() == null){
            return 0;
        }
        MemberShipCard memberShipCard = new MemberShipCard();
        memberShipCard.setCardNo(memberShipCardForm.getCardNo());
        memberShipCard.setHolder(memberShipCardForm.getHolder());
        memberShipCard.setPhoneNumber(memberShipCardForm.getPhoneNumber());
        memberShipCard.setType(memberShipCardForm.getType());
        memberShipCard.setDiscount(memberShipCardForm.getDiscount());
        return memberShipMapper.update(memberShipCard);
    }
}
