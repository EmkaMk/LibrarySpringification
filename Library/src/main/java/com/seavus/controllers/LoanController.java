package com.seavus.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.seavus.entities.Loan;
import com.seavus.service.LoanService;
import com.seavus.service.exceptions.NoSuchElementException;
import com.seavus.utils.Utils;

public class LoanController implements BasicController {

	private LoanService service;
	private Scanner inputScanner = Utils.SCANNER;

	public LoanController(LoanService service) {
		super();
		this.service = service;
	}

	@Override
	public void listOptions() {
		// TODO Auto-generated method stub
		System.out.println("1. List all current loans");
		System.out.println("2. Register new loan");

	}

	@Override
	public void register() throws NoSuchElementException {
		// TODO Auto-generated method stub
		System.out.println("Enter member's username: ");
		String userName = inputScanner.next();
		System.out.println("Enter publication's id : ");
		String id = inputScanner.next();
		System.out.println("Enter start date : ");
		String startDate = inputScanner.next();
		System.out.println("Enter end date: ");
		String endDate = inputScanner.next();
		service.register(userName, id, startDate, endDate);

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		ArrayList<Loan> list = service.listAllLoans();
		for (Loan l : list) {
			System.out.println(l);
		}

	}
}
