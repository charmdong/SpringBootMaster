package com.donggun.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donggun.domain.BoardVO;

@RestController
public class BoardController {
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping(path="/hello")
	public String hello(@RequestParam String name) {
		return "Hello : " + name;
	}
	
	@GetMapping(path="/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		
		board.setSeq(1);
		board.setTitle("테스트 제목");
		board.setWriter("테스터");
		board.setContent("테스트 내용입니다............");
		board.setCreatedDate(new Date());
		board.setCnt(0);
		
		return board;
	}
}
