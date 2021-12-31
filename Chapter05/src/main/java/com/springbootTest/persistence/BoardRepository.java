package com.springbootTest.persistence;

import org.springframework.data.repository.CrudRepository;

import com.springbootTest.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
