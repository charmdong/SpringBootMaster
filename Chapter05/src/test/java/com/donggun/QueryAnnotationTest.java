package com.donggun;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.donggun.domain.Board;
import com.donggun.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	public void testQueryAnnotationTest1() {
//		List<Board> boardList = boardRepo.queryAnnotationTest1("Test Title 10");
//		
//		System.out.println("### Search Result ###");
//		boardList.stream().forEach(board -> System.out.println(board));
//	}	
	
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Object[]> boardList = boardRepo.queryAnnotationTest2("Test Title 10");
//		
//		System.out.println("### Search Result ###");
//		boardList.stream().forEach(board -> System.out.println(Arrays.toString(board)));
//	}
	
//	@Test
//	public void testQueryAnnotationTest3() {
//		List<Object[]> boardList = boardRepo.queryAnnotationTest3("Test Title 10");
//		
//		System.out.println("### Search Result ###");
//		boardList.stream().forEach(board -> System.out.println(Arrays.toString(board)));
//	}
	
	@Test
	public void testQueryAnnotationTest4() {
		Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "seq");
		List<Board> boardList = boardRepo.queryAnnotationTest4(paging);
		
		System.out.println("### Search Result ###");
		boardList.stream().forEach(board -> System.out.println(board));
	}
}
