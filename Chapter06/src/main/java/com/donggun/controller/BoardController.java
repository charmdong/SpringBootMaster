package com.donggun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.donggun.domain.Board;
import com.donggun.domain.Member;
import com.donggun.service.BoardService;

@SessionAttributes("member")
@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}

	@RequestMapping(value="/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		
		return "getBoardList";
	}
	
	@GetMapping(value="/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "getBoard";
	}
	
	@RequestMapping(value="/insertBoardView")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		
		return "insertBoard";
	}
	
	@PostMapping(value="/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		
		boardService.insertBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@PostMapping(value="/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		
		boardService.updateBoard(board);
		
		return "forward:getBoardList";
	}
	
	@GetMapping(value="/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		
		boardService.deleteBoard(board);
		
		return "forward:getBoardList";
	}
}
