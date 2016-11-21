package com.seavus.controllers;

import com.seavus.service.exceptions.EmailExistsException;
import com.seavus.service.exceptions.NoSuchElementException;
import com.seavus.service.exceptions.PublicationExistsException;

public interface BasicController {
	
	public void listOptions();
	public void register() throws NoSuchElementException, EmailExistsException, PublicationExistsException;
	public void list();

}
