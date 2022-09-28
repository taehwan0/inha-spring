package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void updateBoard(BoardVO vo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "update board set title = ?, content = ? where seq = ?"
            );
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.setInt(3, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from board where seq = ?"
            );
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "select * from board where seq = ?"
            );
            stmt.setInt(1, vo.getSeq());
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();

            return setBoardByResultSet(resultSet);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM BOARD"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BoardVO board = setBoardByResultSet(resultSet);
                boardList.add(board);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return boardList;
    }

    private BoardVO setBoardByResultSet(ResultSet resultSet) throws SQLException {
        BoardVO board = new BoardVO();
        board.setTitle(resultSet.getString("title"));
        board.setSeq(resultSet.getInt("seq"));
        board.setContent(resultSet.getString("content"));
        board.setWriter(resultSet.getString("writer"));
        board.setCnt(resultSet.getInt("cnt"));
        board.setRegDate(resultSet.getDate("regdate"));
        return board;
    }
}
