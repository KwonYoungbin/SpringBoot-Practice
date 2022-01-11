package com.springbootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import com.springbootTest.domain.Member;
import com.springbootTest.domain.Role;
import com.springbootTest.persistence.MemberRepository;

@SpringBootTest
@Commit
public class PasswordEncoderTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setId("man");
		member.setPassword(encoder.encode("man1"));
		member.setName("매니저2");
		member.setRole(Role.ROLE_MANAGER);
		member.setEnabled(true);
		memberRepo.save(member);
	}
}
