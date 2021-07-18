package com.donggun.service;

import java.util.List;

import com.donggun.domain.BoardVO;

public interface BoardService {
	
	String Hello(String name);
	
	BoardVO getBoard();
	
	List<BoardVO> getBoardList();
}
