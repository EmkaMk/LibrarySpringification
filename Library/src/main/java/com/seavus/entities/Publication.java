package com.seavus.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class Publication extends BasicEntity {

	@Column
	protected String title;

	public Publication(String title) {
		super();
		this.title = title;
	}

	public Publication() {
		super();// da se definira default constructor za sekoj objekt
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
