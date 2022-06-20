package com.vn.MockProjectWeb.member;

import java.util.List;

public interface MemberService {
	Member saveMember(Member member);
	
	Member checkUsername(String username);
	
	Member checkEmail(String email);
	
	
	Member checkPassword(String password);
	
	List<Member> findAll();
	
	Member findAllById(Integer id);
	
	Member update(Member member);
	


}
