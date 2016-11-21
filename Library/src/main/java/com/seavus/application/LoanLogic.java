package com.seavus.application;

import com.seavus.controllers.LoanController;
import com.seavus.service.exceptions.NoSuchElementException;
import com.seavus.utils.Utils;

public class LoanLogic {

	private LoanController loanController;
	private boolean run = true;

	public LoanLogic(LoanController loanController) {
		super();
		this.loanController = loanController;
	}

	public void run() throws NoSuchElementException {
		while (run) {
			loanController.listOptions();
			String option = Utils.SCANNER.next();
			switch (option) {
			case "1":
				loanController.list();
				break;
			case "2":
				loanController.register();
				break;
			case "3":
				run = false;
				break;
			}
		}
	}
}
