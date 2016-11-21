package com.seavus.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Loan extends BasicEntity {

	private String startDate;
	private String endDate;
	@ManyToOne
	private Member member;
	@ManyToOne
	private Publication publication;

	public Loan(String startDate, String endDate, Member member, Publication p) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.member = member;
		this.publication = p;
	}

	public Loan() {
		super();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
