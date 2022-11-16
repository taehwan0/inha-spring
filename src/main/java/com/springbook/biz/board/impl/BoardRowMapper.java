package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO> {

    @Override
    public BoardVO mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
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
