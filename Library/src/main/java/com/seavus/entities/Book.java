package com.seavus.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Publication {


	@Column(unique=true)
	protected long isbn;

	public Book() {

	}

	public Book(Long isbn,String title) {
		super(title);
		this.isbn=isbn;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", id=" + id + "]";
	}

}
