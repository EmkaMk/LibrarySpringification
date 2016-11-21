package com.seavus.dao;

import java.util.List;

import com.seavus.entities.Member;

public interface MembershipDAO {
	
	public void insertMember(Member m);
	public void updateMember(Member m);
	public void deleteMember(String username);
	public Member getMember(String username);
	public List<Member> list();

}
