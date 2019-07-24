package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.RoleForm;
import com.iverson.erp.pojo.Role;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/19
 */
public interface RoleService {
    Role getRoleNameByNo(String roleNo);

    int create(RoleForm roleForm);

    int update(RoleForm roleForm);

    PageInfo<Role> getList(String roleNo, String roleName, int pageNum, int pageSize);
}
