package com.springbook.biz.user.impl;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void updateUser(UserVO vo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE users SET password = ?, name = ?, role = ? where id = ?"
            );
            stmt.setString(1, vo.getPassword());
            stmt.setString(2, vo.getName());
            stmt.setString(3, vo.getRole());
            stmt.setString(4, vo.getId());
            stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(UserVO vo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM users WHERE id = ?"
            );
            stmt.setString(1, vo.getId());
            stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserVO getUser(UserVO vo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ? AND password = ?"
            );
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            return setUserVO(resultSet);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserVO> getUserList() {
        List<UserVO> userList = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM users"
            );
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                UserVO userVO = setUserVO(resultSet);
                userList.add(userVO);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    private UserVO setUserVO(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");

        return new UserVO(id, password, name, role);
    }
}
