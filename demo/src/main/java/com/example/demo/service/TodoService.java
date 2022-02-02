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
	
	// ����
	public List<TodoEntity> create(final TodoEntity entity){
		validate(entity);
		
		repository.save(entity);
		
		log.info("Entity Id : {} is saved.", entity.getId());
		
		return repository.findByUserId(entity.getUserId());
	}
	
	// ��ȸ
	public List<TodoEntity> retrieve(final String userId){
		return repository.findByUserId(userId);
	}
	
	// ����
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
	
	// ����
	public List<TodoEntity> delete(final TodoEntity entity){
		// (1) ��ƼƼ ��ȿ�� Ȯ��
		validate(entity);
		
		try {
			// (2) ��ƼƼ ����
			repository.delete(entity);
		} catch(Exception e) {
			// (3) Exception �߻� �� id�� exception �α�
			log.error("error deleting entity ", entity.getId(), e);

			// (4) ��Ʈ�ѷ��� exception�� ������. �����ͺ��̽� ���� ������ ĸ��ȭ�Ϸ��� e�� �������� �ʰ� �� exception ������Ʈ�� ����
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
//		// TodoEntity ����
//		TodoEntity entity = TodoEntity.builder().title("My first todo item.").build();
//		// TodoEntity ����
//		repository.save(entity);
//		// TodoEntity �˻�
//		TodoEntity savedEntity = repository.findById(entity.getId()).get();
//		return savedEntity.getTitle();
//	}
}
