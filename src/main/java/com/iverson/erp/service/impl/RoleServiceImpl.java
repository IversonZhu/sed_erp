package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.enums.RoleStatusEnum;
import com.iverson.erp.form.RoleForm;
import com.iverson.erp.mapper.RoleMapper;
import com.iverson.erp.pojo.Role;
import com.iverson.erp.service.ModuleService;
import com.iverson.erp.service.RoleService;
import com.iverson.erp.util.NoGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Role getRoleNameByNo(String roleNo) {
        return roleMapper.getRoleNameByNo(roleNo);
    }

    @Override
    public int create(RoleForm roleForm) {
        Role role = new Role();
        role.setRoleNo(NoGenerateUtil.getRoleNo());
        role.setRoleName(roleForm.getRoleName());
        role.setStatus(RoleStatusEnum.NORMAL.getCode());
        role.setModule(roleForm.getModule());
        return roleMapper.add(role);
    }

    @Override
    public int update(RoleForm roleForm) {
        Role role = new Role();
        role.setRoleNo(roleForm.getRoleNo());
        role.setRoleName(roleForm.getRoleName());
        role.setStatus(roleForm.getStatus());
        role.setModule(roleForm.getModule());
        return roleMapper.update(role);
    }

    @Override
    public PageInfo<Role> getList(String roleNo, String roleName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> roles = roleMapper.getList(roleNo,roleName);
        PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
        return rolePageInfo;
    }

    @Override
    public List<Role> getAll() {
        return roleMapper.getList(null,null);
    }
}
