package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoDTO;

@RestController
@RequestMapping("todo")
public class TodoController {
	@GetMapping("/testTodo")
	public ResponseEntity<?> testTodo(){
		String id = "777";
		String title = "SUCCESS";
		boolean done = true;
		TodoDTO response = TodoDTO.builder().id(id).title(title).done(done).build();
		return ResponseEntity.ok().body(response);
	}
}
