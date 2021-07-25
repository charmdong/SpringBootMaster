package com.donggun.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.donggun.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
	List<Board> findByTitle(String searchKeyword);
	
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	/*
	@Query("SELECT b FROM Board b " + "WHERE b.title like %:searchKeyword% " + "ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
	
	@Query("SELECT b.seq, b.title, b.writer, b.createDate " 
			+ "FROM Board b " 
			+ "WHERE b.title like %:searchKeyword% " 
			+ "ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	@Query(value = "select seq, title, writer, createdate"
			+ "from board where title like '%'||?1||'%'"
			+ "order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest4(Pageable paging);
	*/
}
