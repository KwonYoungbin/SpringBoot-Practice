package com.springbootTest;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootTest.domain.Board;
import com.springbootTest.domain.Member;
import com.springbootTest.persistence.BoardRepository;
import com.springbootTest.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
//	테스트에 필요한 객체 생성 소스 코드
//	@Test
//	public void testManyToOneInsert() {
//		Member member1 = new Member();
//		member1.setId("member1");
//		member1.setPassword("member111");
//		member1.setName("둘리");
//		member1.setRole("User");
//		memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member2");
//		member2.setPassword("member222");
//		member2.setName("도우너");
//		member2.setRole("Admin");
//		memberRepo.save(member2);
//		
//		for(int i=1; i<=3; i++) {
//			Board board = new Board();
//			board.setMember(member1);
//			board.setTitle("둘리가 등록한 게시글 " + i);
//			board.setContent("둘리가 등록한 게시글 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//		
//		for(int i=1; i<=3; i++) {
//			Board board = new Board();
//			board.setMember(member2);
//			board.setTitle("도우너가 등록한 게시글 " + i);
//			board.setContent("도우너가 등록한 게시글 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}
	
//	단방향 다대일 연관관계 매핑에서 검색 기능 테스트
//	@Test
//	public void testManyToOneSelect() {
//		Board board = boardRepo.findById(5L).get();
//		System.out.println("[ " + board.getSeq() + "번 게시글 정보 ]");
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("내용 : " + board.getContent());
//		System.out.println("작성자 : " + board.getMember().getName());
//		System.out.println("작성자 권한 : " + board.getMember().getRole());
//	}

//	양방햔 연관관계 매핑에서의 검색 기능 테스트
//	@Test
//	public void testTwoWayMapping() {
//		Member member = memberRepo.findById("member1").get();
//		
//		System.out.println("============================");
//		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
//		System.out.println("============================");
//		List<Board> list = member.getBoardList();
//		for(Board board : list) {
//			System.out.println(board.toString());
//		}
//	}

//	영속성 전이를 이용한 엔티티 등록
//	@Test
//	public void testManyToOneInsert() {
//		Member member1 = new Member();
//		member1.setId("member1");
//		member1.setPassword("member111");
//		member1.setName("둘리");
//		member1.setRole("User");
////		memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member2");
//		member2.setPassword("member222");
//		member2.setName("도우너");
//		member2.setRole("Admin");
////		memberRepo.save(member2);
//		
//		for(int i=1; i<=3; i++) {
//			Board board = new Board();
//			board.setMember(member1);
//			board.setTitle("둘리가 등록한 게시글 " + i);
//			board.setContent("둘리가 등록한 게시글 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
////			boardRepo.save(board);
//		}
//		memberRepo.save(member1);
//		
//		for(int i=1; i<=3; i++) {
//			Board board = new Board();
//			board.setMember(member2);
//			board.setTitle("도우너가 등록한 게시글 " + i);
//			board.setContent("도우너가 등록한 게시글 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
////			boardRepo.save(board);
//		}
//		memberRepo.save(member2);
//	}
	
	@Test
	public void testCascadeDelete() {
		memberRepo.deleteById("member2");
	}
}
