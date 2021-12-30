package com.springbootTest;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.springbootTest.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		//----------------------- 목록 검색과 JPQL -----------------------
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요.");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			Board board2 = new Board();
			board2.setTitle("JPA 제목2");
			board2.setWriter("관리자2");
			board2.setContent("JPA 글 등록 잘 되네요.2");
			board2.setCreateDate(new Date());
			board2.setCnt(1L);
			
			// 글 등록
			em.persist(board);
			em.persist(board2);
						
			// Transaction commit
			tx.commit();
			
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for (Board brd : boardList) {
				System.out.println("---> " + brd.toString());
			}
			
			tx.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		//-----------------------------------------------------------------------------
	}
	
	
//	public static void main(String[] args) {
//		// EntityManager 생성
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		//----------------------- 엔티티 삭제 -----------------------
//		// Transaction 생성
//		EntityTransaction tx = em.getTransaction();
//		try {
//			// Transaction 시작
//			tx.begin();
//			
//			// 삭제할 게시글 조회
//			Board board1 = em.find(Board.class, 1L);
//			board1.setSeq(1L);
//			
//			// 게시글 삭제
//			em.remove(board1);
//						
//			// Transaction commit
//			tx.commit();
//		} catch(Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			em.close();
//			emf.close();
//		}
//		//-----------------------------------------------------------------------------
//	}
	
	
//	public static void main(String[] args) {
//		// EntityManager 생성
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		//----------------------- 엔티티 수정 -----------------------
//		// Transaction 생성
//		EntityTransaction tx = em.getTransaction();
//		try {
//			// Transaction 시작
//			tx.begin();
//			
//			Board board = em.find(Board.class, 1L);
//			board.setTitle("제목 수정 테스트");
//			
//						
//			// Transaction commit
//			tx.commit();
//		} catch(Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			em.close();
//			emf.close();
//		}
//		//-----------------------------------------------------------------------------
//	}
		
	
//	public static void main(String[] args) {
//		// EntityManager 생성
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		//----------------------- 테이블 생성 및 트랜잭션(INSERT) 수행 -----------------------
//		// Transaction 생성
//		EntityTransaction tx = em.getTransaction();
//		try {
//			// Transaction 시작
//			tx.begin();
//			
//			Board board = new Board();
//			board.setTitle("JPA 제목");
//			board.setWriter("관리자");
//			board.setContent("JPA 글 등록 잘 되네요.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			// 글 등록
//			em.persist(board);
//			
//			// Transaction commit
//			tx.commit();
//		} catch(Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}
//		//-----------------------------------------------------------------------------
//		
//		//----------------------- 테이블의 검색 기능 -----------------------
//		try {
//			Board searchBoard = em.find(Board.class, 1L);
//			System.out.println("---> " + searchBoard.toString());
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			em.close();
//			emf.close();
//		}
//		//-------------------------------------------------------------
//	}
}
