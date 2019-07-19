package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.LoginForm;
import com.iverson.erp.form.UserForm;
import com.iverson.erp.pojo.User;
import com.iverson.erp.vo.UserVO;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/19
 */
public interface UserService {
    UserVO login(LoginForm loginForm);

    int add(UserForm userForm);

    PageInfo<User> getList(String userNo, String roleNo, String userName, String nickName, int pageNum, int pageSize);

    int update(UserForm userForm);
}
