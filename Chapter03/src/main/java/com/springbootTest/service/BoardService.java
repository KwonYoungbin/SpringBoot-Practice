package com.springbootTest.service;

import java.util.List;

import com.springbootTest.domain.BoardVO;

public interface BoardService {
	String hello(String name);
	
	BoardVO getBoard();
	
	List<BoardVO> getBoardList();
}
