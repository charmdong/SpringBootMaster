package com.donggun;

import java.util.List;

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

			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for(Board board: boardList) {
				System.out.println(board);
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}
}
