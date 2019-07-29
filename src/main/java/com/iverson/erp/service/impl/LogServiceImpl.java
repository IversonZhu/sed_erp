package com.iverson.erp.service.impl;

import com.iverson.erp.mapper.LogMapper;
import com.iverson.erp.pojo.LogInfo;
import com.iverson.erp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/29
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void save(LogInfo logInfo) {
        logMapper.save(logInfo);
    }
}
