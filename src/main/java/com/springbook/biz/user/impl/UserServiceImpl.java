package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void insertUser(UserVO vo) {
        userDAO.insertUser(vo);
    }
}
