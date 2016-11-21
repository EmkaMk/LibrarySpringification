package com.seavus.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.seavus.entities.Magazine;
import com.seavus.entities.Publication;
import com.seavus.service.PublicationsService;
import com.seavus.service.exceptions.EmailExistsException;
import com.seavus.service.exceptions.NoSuchElementException;
import com.seavus.service.exceptions.PublicationExistsException;
import com.seavus.utils.Utils;

public class MagazineController implements BasicController {

	private PublicationsService publicationService;
	private Scanner inputScanner = Utils.SCANNER;

	public MagazineController(PublicationsService publicationService) {
		super();
		this.publicationService = publicationService;
	}

	@Override
	public void listOptions() {
		// TODO Auto-generated method stub
		System.out.println("1. List all publications");
		System.out.println("2. Register book");
		System.out.println("3. Register magazine");
		System.out.println("4. Update book");
		System.out.println("5. Update magazine");
		System.out.println("6. Delete book");
		System.out.println("7. Delete magazine");
		System.out.println("8. Exit");

	}

	@Override
	public void register() throws NoSuchElementException, EmailExistsException, PublicationExistsException {
		// TODO Auto-generated method stub
		System.out.println("Enter ISSN:");
		Long issn = Long.valueOf(inputScanner.next());
		System.out.println("Enter title:");
		String title = inputScanner.next();
		Magazine m = new Magazine(issn, title);
		publicationService.registerPublication(m);

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		ArrayList<Publication> publications = publicationService.listAllPublications();
		for (Publication p : publications) {
			if (p instanceof Magazine)
				System.out.println(p);
		}

	}

	public void updateMagazne() {
		System.out.println("Enter ISSN:");
		Long issn = Long.valueOf(inputScanner.next());
		System.out.println("Enter new title:");
		String title = inputScanner.next();
		Magazine m = new Magazine(issn, title);
		publicationService.updateMagazine(m);

	}

	public void deleteMagazine() {
		System.out.println("Enter ISSN of the magazine:");
		Long issn = Long.valueOf(inputScanner.next());
		publicationService.deleteMagazine(issn);
	}

}
