package com.donggun.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donggun.domain.Member;
import com.donggun.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepo;

	@Autowired
	public MemberServiceImpl(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}
	
	@Override
	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepo.findById(member.getId());
		
		if(findMember.isPresent()) {
			return findMember.get();
		}
		
		return null;
	}
}
