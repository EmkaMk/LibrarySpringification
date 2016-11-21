package com.seavus.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member extends BasicEntity {

	@Column(unique = true)
	private String userName;
	private String email;
	@OneToMany(mappedBy = "member")
	private Set<Loan> loans;

	public Member() {
		super();
	}

	public Member(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [userName=" + userName + ", email=" + email + ", id=" + id + "]";
	}

}
