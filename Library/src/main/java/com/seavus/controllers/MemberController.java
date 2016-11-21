package com.seavus.controllers;

import java.util.List;
import java.util.Scanner;

import com.seavus.entities.Member;
import com.seavus.service.MemberService;
import com.seavus.service.exceptions.EmailExistsException;
import com.seavus.service.exceptions.NoSuchElementException;
import com.seavus.utils.Utils;

public class MemberController implements BasicController {

	private MemberService service;
	private Scanner inputScanner = Utils.SCANNER;

	public MemberController(MemberService service) {
		super();
		this.service = service;
	}

	@Override
	public void listOptions() {
		// TODO Auto-generated method stub
		System.out.println("1. List all current members");
		System.out.println("2. Register new member");

	}

	@Override
	public void register() throws NoSuchElementException, EmailExistsException {
		// TODO Auto-generated method stub
		System.out.println("Enter member's username: ");
		String userName = inputScanner.next();
		System.out.println("Enter member's email : ");
		String email = inputScanner.next();
		service.registerMember(userName, email);

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		List<Member> list = service.listMembers();
		for (Member m : list) {
			System.out.println(m);
		}

	}
}
