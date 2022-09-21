package com.springbook.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

    public static void main(String[] args) {
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        BoardService boardService = container.getBean("boardService", BoardService.class);

        BoardVO vo = new BoardVO();
        vo.setTitle("111");
        vo.setWriter("111");
        vo.setContent("111");

        boardService.insertBoard(vo);
    }
}
