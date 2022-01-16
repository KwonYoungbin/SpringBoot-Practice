package com.yb.board.service;

import org.springframework.data.domain.Page;

import com.yb.board.domain.Board;
import com.yb.board.domain.Search;

public interface BoardService {
	void insertBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(Board board);
	
	Board getBoard(Board board);
	
//	원래 버전
//	Page<Board> getBoardList(Board board);
	
//	검색 기능 추가 버전
	Page<Board> getBoardList(Search Search);
}
