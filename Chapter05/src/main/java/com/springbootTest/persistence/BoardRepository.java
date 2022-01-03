package com.springbootTest.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

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
	
	// 페이징 처리
	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
}
