package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void insertUser(UserVO vo) {
        userDAO.insertUser(vo);
    }

    @Override
    public void updateUser(UserVO vo) {
        userDAO.updateUser(vo);
    }

    @Override
    public void deleteUser(UserVO vo) {
        userDAO.deleteUser(vo);
    }

    @Override
    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }

    @Override
    public List<UserVO> getUserList() {
        return userDAO.getUserList();
    }
}
