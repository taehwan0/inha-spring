package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAOSpring implements BoardDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertBoard(BoardVO vo) {
        jdbcTemplate.update(
            "INSERT INTO board (title, writer, content) values (?, ?, ?)",
            vo.getTitle(),
            vo.getWriter(),
            vo.getContent()
        );
    }

    @Override
    public void updateBoard(BoardVO vo) {
        jdbcTemplate.update(
            "UPDATE board SET title = ?, content = ? WHERE seq = ?",
            vo.getTitle(),
            vo.getContent(),
            vo.getSeq()
        );
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        jdbcTemplate.update(
            "DELETE FROM board WHERE seq = ?",
            vo.getSeq()
        );
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM board WHERE seq = ?",
            new BoardRowMapper(),
            vo.getSeq()
        );
    }

    @Override
    public List<BoardVO> getBoardList() {
        return jdbcTemplate.query(
            "SELECT * FROM board",
            new BoardRowMapper()
        );
    }
}
