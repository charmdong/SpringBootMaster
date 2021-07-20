package com.donggun;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.donggun.domain.Board;

public class JPAClient {
	
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			/*
			 * Board board = new Board();
			 * 
			 * board.setTitle("JPA Title"); board.setWriter("Admin");
			 * board.setContent("JPA 글 등록 잘 되네요."); board.setCreateDate(new Date());
			 * board.setCnt(0L);
			 * 
			 * em.persist(board);
			 */
			Board searchBoard = em.find(Board.class, 1L);
			System.out.println(searchBoard);
			
			// tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			// tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		
	}
}
