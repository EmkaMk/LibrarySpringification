package com.seavus.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Publication {

	@Column(unique = true)
	protected long issn;

	public Magazine() {

	}

	public Magazine(Long issn, String title) {
		super(title);
		this.issn = issn;

	}

	public long getIssn() {
		return issn;
	}

	public void setIssn(long issn) {
		this.issn = issn;
	}

	@Override
	public String toString() {
		return "Magazine [issn=" + issn + ", title=" + title + ", id=" + id + "]";
	}

}
