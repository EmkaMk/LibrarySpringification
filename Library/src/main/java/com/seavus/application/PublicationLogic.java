package com.seavus.application;

import com.seavus.controllers.BookController;
import com.seavus.controllers.MagazineController;
import com.seavus.service.exceptions.EmailExistsException;
import com.seavus.service.exceptions.NoSuchElementException;
import com.seavus.service.exceptions.PublicationExistsException;
import com.seavus.utils.Utils;

public class PublicationLogic {

	private BookController bookController;
	private MagazineController magazineController;
	private boolean run = true;

	public PublicationLogic(BookController bookController, MagazineController magazineController) {
		this.bookController = bookController;
		this.magazineController = magazineController;
	}

	public void run() throws NoSuchElementException, EmailExistsException {
		while (run) {
			bookController.list();
			String option = Utils.SCANNER.next();
			switch (option) {
			case "1":
				magazineController.list();
				break;
			case "2":
				try {
					bookController.register();
				} catch (PublicationExistsException e) {
					// TODO Auto-generated catch block
					System.out.println("This book has already been registered!");
				}
				break;
			case "3":
				try {
					magazineController.register();
				} catch (PublicationExistsException e) {
					// TODO Auto-generated catch block
					System.out.println("This magazine has already been registered!");
				}
				break;
			case "4":
				bookController.updateBook();
				break;
			case "5":
				magazineController.updateMagazne();
				break;
			case "6":
				bookController.deleteBook();
				break;
			case "7":
				magazineController.deleteMagazine();
				break;
			case "8":
				run = false;
				break;
			}
		}
	}

}
