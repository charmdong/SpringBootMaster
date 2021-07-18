package com.donggun.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.donggun.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public String Hello(String name) {
		return "Hello : " + name;
	}

	@Override
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

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		
		for(int iter = 1; iter <= 10; iter++) {
			BoardVO board = new BoardVO();
			
			board.setSeq(1);
			board.setTitle("테스트 제목");
			board.setWriter("테스터");
			board.setContent("테스트 내용입니다............");
			board.setCreatedDate(new Date());
			board.setCnt(0);
			
			boardList.add(board);
		}
		
		return boardList;
	}

}
