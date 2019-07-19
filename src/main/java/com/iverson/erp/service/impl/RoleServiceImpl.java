package com.iverson.erp.service.impl;

import com.iverson.erp.mapper.RoleMapper;
import com.iverson.erp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/19
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public String getRoleNameByNo(String roleNo) {
        return roleMapper.getRoleNameByNo(roleNo);
    }
}
