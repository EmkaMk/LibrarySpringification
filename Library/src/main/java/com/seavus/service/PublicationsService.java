package com.seavus.service;

import java.util.ArrayList;

import com.seavus.dao.DAOPublications;
import com.seavus.dao.PublicationsDAO;
import com.seavus.entities.Book;
import com.seavus.entities.Magazine;
import com.seavus.entities.Publication;
import com.seavus.service.exceptions.PublicationExistsException;

public class PublicationsService {
	
	private PublicationsDAO publications;

	public PublicationsService(PublicationsDAO publications) {
		super();
		this.publications = publications;
	}
	
	public void registerPublication(Publication p) throws PublicationExistsException
	{
		Validator.checkBook(publications.list(), p);
		publications.insert(p);
	}
	
	public void updateBook(Book b)
	{
		publications.update(b);
	}
	
	public void updateMagazine(Magazine m)
	{
		publications.update(m);
	}
	
	public ArrayList<Publication> listAllPublications()
	{
		return publications.list();
	}
	
	public void deleteBook(Long isbn)
	{
		publications.deleteBook(isbn);
	}
	
	public void deleteMagazine(Long issn)
	{
		publications.deleteMagazine(issn);
	}

}
