package com.donggun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.donggun.domain.Board;
import com.donggun.service.BoardService;

@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value="/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList", boardList);
		
		return "getBoardList";
	}
	
	@GetMapping(value="/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		
		return "getBoard";
	}
	
	
	@RequestMapping(value="/insertBoardView")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	@PostMapping(value="/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@PostMapping(value="/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		
		return "forward:getBoardList";
	}
	
	@GetMapping(value="/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		
		return "forward:getBoardList";
	}
}
