package com.seavus.service;

import java.util.List;

import com.seavus.entities.Book;
import com.seavus.entities.Magazine;
import com.seavus.entities.Member;
import com.seavus.entities.Publication;
import com.seavus.service.exceptions.EmailExistsException;
import com.seavus.service.exceptions.PublicationExistsException;

public class Validator {
	
	public static void checkEmail(List<Member> list, Member member)
			throws EmailExistsException {
		for (Member x : list) {
			if (x.getEmail().equals(member.getEmail())
					&& x.getId() != member.getId()) {
				throw new EmailExistsException();
			}
		}
	}

	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
	public static void checkBook(List<Publication> list, Publication p)
			throws PublicationExistsException {
		for (Publication x : list) {
			if (((Book) x).getIsbn()==((Book) p).getIsbn() && x.getId() != p.getId()) {
				throw new PublicationExistsException();
			}
		}
	}

	public static void checkMagazine(List<Publication> list, Publication p)
			throws PublicationExistsException {
		for (Publication x : list) {
			if(x instanceof Magazine)
			{
			if (((Magazine) x).getIssn()==((Magazine) p).getIssn()
					&& x.getId() != p.getId()) {
				throw new PublicationExistsException();
			}
			}
		}
	}
}
