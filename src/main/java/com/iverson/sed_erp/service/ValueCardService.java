package com.iverson.sed_erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.sed_erp.form.ValueCardForm;
import com.iverson.sed_erp.pojo.ValueCard;

public interface ValueCardService {

    int addOne(ValueCardForm valueCardForm);

    PageInfo<ValueCard> getList(int pageNum, int pageSize);

    ValueCard getCardByNo(String cardNo);
}
