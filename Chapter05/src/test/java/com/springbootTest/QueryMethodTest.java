package com.springbootTest;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.springbootTest.domain.Board;
import com.springbootTest.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
//	@BeforeEach
//	public void dataPrepare() {
//		for(int i=1; i<=200; i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목 "+i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용 "+i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}
//	

//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
//	@Test
//	public void testByContentContaning() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}		
//	}
	
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
	// 페이징만 처리하는 방법
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5);
//		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
	// 페이징 처리와 함께 데이터 정렬해서 출력하는 방법
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
