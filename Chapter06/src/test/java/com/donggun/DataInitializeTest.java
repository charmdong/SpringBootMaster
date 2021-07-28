package com.donggun;

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
public class DataInitializeTest {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDataInsert() {
		Member member1 = new Member();
		
		member1.setId("member1");
		member1.setName("donggun");
		member1.setPassword("member111");
		member1.setRole("ROLE_ADMIN");
		
		memberRepo.save(member1);
		
		Member member2 = new Member();
		
		member2.setId("member2");
		member2.setName("eunjung");
		member2.setPassword("member222");
		member2.setRole("ROLE_USER");
		
		memberRepo.save(member2);
		
		for(int index = 1; index <= 3; index++) {
			Board board = new Board();
			
			board.setWriter("donggun");
			board.setTitle("board written by donggun " + index);
			board.setContent("Content written by donggun " + index);
			
			boardRepo.save(board);
		}
		
		for(int index = 1; index <= 3; index++) {
			Board board = new Board();
			
			board.setWriter("eunjung");
			board.setTitle("board written by eunjung " + index);
			board.setContent("Content written by eunjung " + index);
			
			boardRepo.save(board);
		}
	}
}
