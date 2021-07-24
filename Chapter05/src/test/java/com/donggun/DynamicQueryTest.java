package com.donggun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.donggun.domain.Board;
import com.donggun.domain.QBoard;
import com.donggun.persistence.DynamicBoardRepository;
import com.querydsl.core.BooleanBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {

	@Autowired
	private DynamicBoardRepository boardRepo;
	
	@Test
	public void testDynamicQuery() {
		String searchCondition = "TITLE";
		String searchKeyword = "Test Title 10";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		}
		else if(searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(1,  5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println("### Search Result ###");
		boardList.stream().forEach(board -> System.out.println(board));
	}
}
