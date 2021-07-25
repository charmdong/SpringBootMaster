package com.donggun;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.donggun.domain.Board;
import com.donggun.domain.Member;
import com.donggun.persistence.BoardRepository;
import com.donggun.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	/*
	@Test
	public void testManyToOneInsert() {
		Member member1 = new Member();
		
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("둘리");
		member1.setRole("user");
		
		// memberRepo.save(member1);
		
		Member member2 = new Member();
		
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("도우너");
		member2.setRole("user");
		
		// memberRepo.save(member2);
		
		for(int index = 1; index <= 3; index++) {
			Board board = new Board();
			
			board.setMember(member1);
			board.setTitle("둘리가 등록한 게시글 " + index);
			board.setContent("둘리가 등록한 게시글 내용 " + index);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			// boardRepo.save(board);
		}
		memberRepo.save(member1);
		
		for(int index = 1; index <= 3; index++) {
			Board board = new Board();
			
			board.setMember(member2);
			board.setTitle("도우너가 등록한 게시글 " + index);
			board.setContent("도우너가 등록한 게시글 내용 " + index);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			// boardRepo.save(board);
		}
		memberRepo.save(member2);
	}
	*/
	
//	@Test
//	public void testManyToOneSelect() {
//		Board board = boardRepo.findById(5L).get();
//		
//		System.out.println(board);
//	}
	
//	@Test
//	public void testTwoWayMapping() {
//		Member member = memberRepo.findById("member1").get();
//		
//		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
//		member.getBoardList().stream().forEach(board -> System.out.println(board));
//	}
	
	@Test
	public void testCascadeDelete() {
		memberRepo.deleteById("member2");
	}
}
