package com.donggun.persistence;

import org.springframework.data.repository.CrudRepository;

import com.donggun.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
