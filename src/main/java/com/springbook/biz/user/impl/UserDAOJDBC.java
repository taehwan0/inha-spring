package com.springbook.biz.user.impl;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAOJDBC implements UserDAO {

    @Override
    public void insertUser(UserVO vo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO users (id, password, name, role) values (?, ?, ?, ?)"
            );
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            stmt.setString(3, vo.getName());
            stmt.setString(4, vo.getRole().toUpperCase());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
