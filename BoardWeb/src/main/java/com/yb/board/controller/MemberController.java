package com.yb.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yb.board.domain.Member;
import com.yb.board.domain.Role;
import com.yb.board.service.MemberService;

@Controller
@RequestMapping("/system/")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/addMember")
	public String insertMemberView() {
		return "/system/addMember";
	}
	
	@PostMapping("/addMember")
	public String insertMember(Member member) {
		member.setPassword(encoder.encode(member.getPassword()));
		member.setEnable(true);
		member.setRole(Role.ROLE_MEMBER);
		memberService.insertMember(member);
		return "redirect:/";
	}
}
