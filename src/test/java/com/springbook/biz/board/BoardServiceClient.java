package com.springbook.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

    public static void main(String[] args) {
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        BoardService boardService = container.getBean("boardService", BoardService.class);

//        for(int i = 1; i <= 10; i++) {
//            BoardVO vo = new BoardVO();
//            vo.setTitle(String.valueOf(i));
//            vo.setWriter(String.valueOf(i));
//            vo.setContent(String.valueOf(i));
//            boardService.insertBoard(vo);
//        }

//        BoardVO vo = new BoardVO();
//        vo.setTitle("edit");
//        vo.setContent("edit");
//        vo.setSeq(2);
//
//        boardService.updateBoard(vo);

//        BoardVO vo = new BoardVO();
//        vo.setSeq(2);
//
//        boardService.deleteBoard(vo);

//        BoardVO vo = new BoardVO();
//        vo.setSeq(1);
//        BoardVO board = boardService.getBoard(vo);
//        System.out.println(board.toString());

        List<BoardVO> boardList = boardService.getBoardList();
        boardList.forEach(System.out::println);
    }
}
