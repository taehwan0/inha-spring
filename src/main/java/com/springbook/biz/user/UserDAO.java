package com.springbook.biz.user;

import java.util.List;

public interface UserDAO {
    void insertUser(UserVO vo);
    void updateUser(UserVO vo);
    void deleteUser(UserVO vo);
    UserVO getUser(UserVO vo);
    List<UserVO> getUserList();
}
