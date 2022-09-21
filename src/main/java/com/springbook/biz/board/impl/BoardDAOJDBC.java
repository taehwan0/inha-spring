package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardDAOJDBC implements BoardDAO {
    @Override
    public void insertBoard(BoardVO vo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into board (title, writer, content) values (?, ?, ?)");
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getWriter());
            stmt.setString(3, vo.getContent());
            stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
