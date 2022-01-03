package com.springbootTest.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springbootTest.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	// 기본형 쿼리 메세지
	List<Board> findByTitle(String searchKeyword);
	
	// SQL의 LIKE 연산자 사용
	List<Board> findByContentContaining(String searchKeyword);
	
	// 여러 조건을 사용하는 WHERE절
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	// 데이터 정렬하기
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	// 페이징 처리 및 리턴 타입 변경(List -> Page)
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	// Query어노테이션을 이용하여 JPQL 등록
	// 위치 기반 파라미터 사용('?1'은 첫 번째 파라미터를 의미)
	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String searchKeyword);
	
	// 이름 기반 파라미터 사용('?1'은 첫 번째 파라미터를 의미)
	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1_1(@Param("searchKeyword")String searchKeyword);
	
	// 특정 변수만 조회(이때 List의 타입은 엔티티 객체가 아닌 Object[]로 해야함
	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(String searchKeyword);
}
