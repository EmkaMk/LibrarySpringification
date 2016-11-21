package com.seavus.dao;

import java.util.ArrayList;

import com.seavus.entities.BasicEntity;
import com.seavus.entities.Book;
import com.seavus.entities.Magazine;
import com.seavus.entities.Publication;

public interface PublicationsDAO {

	public void insert(Publication p);

	public void update(Book b);

	public void update(Magazine m);

	public void deleteBook(Long isbn);

	public void deleteMagazine(Long issn);

	public ArrayList<Publication> list();
	
	public Publication getByID(String id);

}
