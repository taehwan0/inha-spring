package com.springbook.biz.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardTestCase {

   private final static AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
   private final static BoardService boardService = container.getBean("boardService", BoardService.class);

    // BoardService boardService;
    //
    // @BeforeEach
    // void setUp() {
    //     AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    //     boardService = container.getBean("boardService", BoardService.class);
    // }

    @Test
    void insertBoard() {
        BoardVO vo = new BoardVO();
        vo.setTitle("000");
        vo.setWriter("000");
        vo.setContent("000");
        boardService.insertBoard(vo);
    }

    @Test
    void updateBoard() {
        BoardVO vo = new BoardVO();
        vo.setSeq(18);
        vo.setTitle("999");
        vo.setContent("999");

        boardService.updateBoard(vo);

        BoardVO board = boardService.getBoard(vo);
        System.out.println("updatedBoard: " + board);

    }

    @Test
    void deleteBoard() {
        BoardVO vo = new BoardVO();
        vo.setSeq(3);

        boardService.deleteBoard(vo);
    }

    @Test
    void getBoard() {
        BoardVO vo = new BoardVO();
        vo.setSeq(1);
        BoardVO board = boardService.getBoard(vo);
        System.out.println(board);
    }

    @Test
    void getBoardList() {
        List<BoardVO> boardList = boardService.getBoardList();
        boardList.forEach(System.out::println);
    }
}
