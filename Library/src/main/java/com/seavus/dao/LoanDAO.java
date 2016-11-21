package com.seavus.dao;

import java.util.ArrayList;

import com.seavus.entities.Loan;

public interface LoanDAO {
	
	public void registerLoan(Loan l);
	public ArrayList<Loan> listLoans();
	public Loan getById(String id);

}
