package com.donggun;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.donggun.domain.Board;
import com.donggun.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepo;
	
//	@Before
//	public void dataPrepare() {
//		for(int iter = 1; iter <= 200; iter++) {
//			Board board = new Board();
//			
//			board.setTitle("Test Title " + iter);
//			board.setWriter("Tester");
//			board.setContent("Test Content " + iter);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			boardRepo.save(board);
//		}
//	}
//	
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("Test Title 10");
//		
//		System.out.println("Search Result");
//		for(Board board: boardList) {
//			System.out.println(board);
//		}
//	}
	
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		
//		System.out.println("### Search Result ###");
//		Stream<Board> stream = boardList.stream();
//		
//		stream.forEach(board -> System.out.println(board));
//	}
	
//	@Test
//	public void testFindByContentContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("### Search Result ###");
//		Stream<Board> stream = boardList.stream();
//		
//		stream.forEach(board -> System.out.println(board));
//	}
	
	@Test
	public void testFindByTitleContaining( ) {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		
		Page<Board> pageInfo = boardRepo.findByTitleContaining("Title", paging);
		
		System.out.println("PAGE SIZE : " + pageInfo.getSize());
		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
		System.out.println("NEXT : " + pageInfo.nextPageable());
		
		List<Board> boardList = pageInfo.getContent();
		
		System.out.println("### Search Result ###");
		boardList.stream().forEach(board -> System.out.println(board));
	}
}
