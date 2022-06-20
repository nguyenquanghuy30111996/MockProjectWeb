package com.vn.MockProjectWeb.member;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository repo;

	@Override
	public Member saveMember(Member member) {

		return repo.save(member);
	}

	@Override
	public Member checkUsername(String username) {
		return repo.checkUsername(username);
	}

	@Override
	public Member checkEmail(String email) {
		return repo.checkEmail(email);
	}

	@Override
	public Member checkPassword(String password) {
		return repo.checkPassword(password);
	}

	@Override
	public List<Member> findAll() {
		return repo.findAll();
	}

	@Override
	public Member findAllById(Integer id) {
		Optional<Member> member = repo.findById(id);
		if (member.isPresent()) {
			return member.get();

		}
		return null;
	}

	@Override
	public Member update(Member member) {
		
		repo.updateMember(member.getFullName(), member.getDateOfBirth(), member.getGender(),member.getEmail(), member.getPhoneNumber(), member.getAddress(), member.getPassword(), member.getRePassword(), member.getId());
		return member;
	}
}
