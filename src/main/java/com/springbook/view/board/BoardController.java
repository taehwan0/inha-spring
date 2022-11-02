package com.springbook.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping({"/", "/index"})
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/insertBoard.do")
	public void insertBoard(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
	}

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO boardVO, ModelAndView modelAndView) {
		BoardVO board = boardService.getBoard(boardVO);
		modelAndView.addObject("board", board);
		modelAndView.setViewName("getBoard.jsp");
		return modelAndView;
	}

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(ModelAndView modelAndView) {
		List<BoardVO> boardList = boardService.getBoardList();
		modelAndView.addObject("boardList", boardList);
		modelAndView.setViewName("getBoardList.jsp");
		return modelAndView;
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO boardVO) {
		boardService.deleteBoard(boardVO);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		return "getBoardList.do";
	}
}
