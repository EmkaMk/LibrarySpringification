package com.seavus.service;

import java.util.List;

import com.seavus.dao.MembershipDAO;
import com.seavus.entities.Member;
import com.seavus.service.exceptions.EmailExistsException;

public class MemberService {

	private MembershipDAO memberDao;

	public MemberService(MembershipDAO memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	public void registerMember(String name,String email) throws EmailExistsException
	{
		Member m=new Member();
		m.setUserName(name);
		m.setEmail(email);
		Validator.checkEmail(memberDao.list(), m);
		memberDao.insertMember(m);
	}
	
	public List<Member> listMembers()
	{
		return memberDao.list();
	}
}
