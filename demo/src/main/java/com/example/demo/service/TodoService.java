package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	// 생성
	public List<TodoEntity> create(final TodoEntity entity){
		validate(entity);
		
		repository.save(entity);
		
		log.info("Entity Id : {} is saved.", entity.getId());
		
		return repository.findByUserId(entity.getUserId());
	}
	
	// 조회
	public List<TodoEntity> retrieve(final String userId){
		return repository.findByUserId(userId);
	}
	
	// 수정
	public List<TodoEntity> update(final TodoEntity entity){
		validate(entity);
		
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		original.ifPresent(todo -> {
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			repository.save(todo);
		});
		
		return retrieve(entity.getUserId());
	}
	
	// 삭제
	public List<TodoEntity> delete(final TodoEntity entity){
		// (1) 엔티티 유효성 확인
		validate(entity);
		
		try {
			// (2) 엔티티 삭제
			repository.delete(entity);
		} catch(Exception e) {
			// (3) Exception 발생 시 id와 exception 로깅
			log.error("error deleting entity ", entity.getId(), e);

			// (4) 컨트롤러로 exception을 보낸다. 데이터베이스 내부 로직을 캡슐화하려면 e를 리턴하지 않고 새 exception 오브젝트를 리턴
			throw new RuntimeException("error deleting entity " + entity.getId());
		}
		
		return retrieve(entity.getUserId());
	}
	
	private void validate(final TodoEntity entity) {
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}
		
		if(entity.getUserId() == null) {
			log.warn("Unknown user.");
			throw new RuntimeException("Unknown user.");
		}
	}
	
//	public String testService() {
//		// TodoEntity 생성
//		TodoEntity entity = TodoEntity.builder().title("My first todo item.").build();
//		// TodoEntity 저장
//		repository.save(entity);
//		// TodoEntity 검색
//		TodoEntity savedEntity = repository.findById(entity.getId()).get();
//		return savedEntity.getTitle();
//	}
}
