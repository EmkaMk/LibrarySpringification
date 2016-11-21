package com.seavus.service;

import java.util.ArrayList;

import javax.sql.rowset.serial.SerialArray;

import com.seavus.dao.DAOLoan;
import com.seavus.dao.DAOMembers;
import com.seavus.dao.DAOPublications;
import com.seavus.dao.LoanDAO;
import com.seavus.dao.MembershipDAO;
import com.seavus.dao.PublicationsDAO;
import com.seavus.entities.Loan;
import com.seavus.entities.Member;
import com.seavus.entities.Publication;
import com.seavus.service.exceptions.NoSuchElementException;

public class LoanService {

	private LoanDAO daoLoan;
	private MembershipDAO daoMembers;
	private PublicationsDAO daoPublications;

	public LoanService(LoanDAO daoLoan,MembershipDAO daoMembers,PublicationsDAO daoPublications) {
		super();
		this.daoLoan = daoLoan;
		this.daoMembers=daoMembers;
		this.daoPublications=daoPublications;
	}

	public void register(String userName,String id,String startDate,String endDate) throws NoSuchElementException {
		if(userName.equals(null) || id.equals(null))
		{
			throw new NoSuchElementException();
		}
		Member m=daoMembers.getMember(userName);
		Publication p=daoPublications.getByID(id);
		Loan l=new Loan(startDate, endDate, m,p);
		daoLoan.registerLoan(l);
	}
	
	public ArrayList<Loan> listAllLoans()
	{
		return daoLoan.listLoans();
	}
	
	public Loan getLoanbyID(String id)
	{
		Loan l= daoLoan.getById(id);
		return l;
	}
}
