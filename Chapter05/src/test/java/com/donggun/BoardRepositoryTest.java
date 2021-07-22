package com.donggun;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.donggun.domain.Board;
import com.donggun.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;
	
	/*
	 * @Test public void testInsertBoard() { Board board = new Board();
	 * 
	 * board.setTitle("첫 번째 게시글"); board.setWriter("테스터");
	 * board.setContent("Well done?"); board.setCreateDate(new Date());
	 * board.setCnt(0L);
	 * 
	 * boardRepo.save(board); }
	 * 
	 * @Test public void testGetBoard() { Board board =
	 * boardRepo.findById(1L).get();
	 * 
	 * System.out.println(board); }
	 * 
	 * @Test public void testUpdateBoard() { Board board =
	 * boardRepo.findById(1L).get();
	 * 
	 * board.setTitle("updateTitle"); boardRepo.save(board); }
	 */
	
	@Test
	public void deleteBoard() {
		boardRepo.deleteById(1L);
	}
}
