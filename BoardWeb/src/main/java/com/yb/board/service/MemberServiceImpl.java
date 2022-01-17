package com.yb.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.board.domain.Member;
import com.yb.board.domain.Role;
import com.yb.board.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		memberRepo.save(member);
	}

}
