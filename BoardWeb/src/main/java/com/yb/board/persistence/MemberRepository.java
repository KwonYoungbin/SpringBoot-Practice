package com.yb.board.persistence;

import org.springframework.data.repository.CrudRepository;

import com.yb.board.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
