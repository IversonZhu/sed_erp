package com.iverson.sed_erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.ValueCardForm;
import com.iverson.sed_erp.mapper.ValueCardMapper;
import com.iverson.sed_erp.pojo.ValueCard;
import com.iverson.sed_erp.service.ValueCardService;
import com.iverson.sed_erp.util.NoGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ValueCardServiceImpl implements ValueCardService {

    @Autowired
    private ValueCardMapper valueCardMapper;

    @Override
    @Transactional
    public int addOne(ValueCardForm valueCardForm) {
        ValueCard valueCard = new ValueCard();
        valueCard.setCardNo(NoGenerateUtil.getValueCardNo());
        valueCard.setHolder(valueCardForm.getHolder());
        valueCard.setBalance(valueCardForm.getBalance());
        valueCard.setPhoneNumber(valueCardForm.getPhoneNumber());
        valueCard.setCreateTime(new Date());
        valueCard.setModifyTime(new Date());
        return valueCardMapper.addOne(valueCard);
    }

    @Override
    public PageInfo<ValueCard> getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ValueCard> valueCards = valueCardMapper.getList();
        PageInfo<ValueCard> valueCardPageInfo = new PageInfo<>(valueCards);
        return valueCardPageInfo;
    }

    @Override
    public ValueCard getCardByNo(String cardNo) {
        ValueCard valueCard = valueCardMapper.searchValueCardByCardNo(cardNo);
        return valueCard;
    }
}
