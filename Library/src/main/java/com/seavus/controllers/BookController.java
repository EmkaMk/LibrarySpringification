package com.seavus.controllers;

import java.util.Scanner;

import com.seavus.entities.Book;
import com.seavus.service.PublicationsService;
import com.seavus.service.exceptions.EmailExistsException;
import com.seavus.service.exceptions.NoSuchElementException;
import com.seavus.service.exceptions.PublicationExistsException;
import com.seavus.utils.Utils;

public class BookController implements BasicController {

	private PublicationsService publicationService;
	private Scanner inputScanner = Utils.SCANNER;

	public BookController(PublicationsService publicationService) {
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
		System.out.println("Enter ISBN:");
		Long isbn = Long.valueOf(inputScanner.next());
		System.out.println("Enter title:");
		String title = inputScanner.next();
		Book b = new Book(isbn, title);
		publicationService.registerPublication(b);

	}

	public void updateBook() {
		System.out.println("Enter ISBN:");
		Long isbn = Long.valueOf(inputScanner.next());
		System.out.println("Enter new title:");
		String title = inputScanner.next();
		Book b = new Book(isbn, title);
		publicationService.updateBook(b);

	}

	public void deleteBook() {
		System.out.println("Enter ISBN of the book:");
		Long isbn = Long.valueOf(inputScanner.next());
		publicationService.deleteBook(isbn);
	}

	@Override
	public void list() {
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

}
