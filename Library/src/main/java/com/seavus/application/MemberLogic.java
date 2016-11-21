package com.seavus.application;

import com.seavus.controllers.MemberController;
import com.seavus.service.exceptions.EmailExistsException;
import com.seavus.service.exceptions.NoSuchElementException;
import com.seavus.utils.Utils;

public class MemberLogic {

	private MemberController controller;
	private boolean run = true;

	public MemberLogic(MemberController controller) {
		super();
		this.controller = controller;
	}

	public void run() throws NoSuchElementException {
		while (run) {
			controller.listOptions();
			String option = Utils.SCANNER.next();
			switch (option) {
			case "1":
				try {
					controller.register();
				} catch (EmailExistsException e) {
					// TODO Auto-generated catch block
					System.out.println("This member is already registered!");
				}
			case "2":
				controller.list();
				break;
			case "3":
				run = false;
				break;
			}
		}
	}

}
