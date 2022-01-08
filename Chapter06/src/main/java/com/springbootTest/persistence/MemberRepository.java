package com.springbootTest.persistence;

import org.springframework.data.repository.CrudRepository;

import com.springbootTest.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
