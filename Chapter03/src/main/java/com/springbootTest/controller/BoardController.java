package com.springbootTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootTest.domain.BoardVO;
import com.springbootTest.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/hello")
	public String hello(String name) {
		return boardService.hello(name);
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		return boardService.getBoard();
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList(){
		return boardService.getBoardList();
	}
}
