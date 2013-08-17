package org.simple.angularjs.contact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contact")
@SuppressWarnings("serial")
public class Contact extends PersistenceEntity {
	
	@Column(name="name")
	private String name;

	@Column(name="phone")
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return getName();
	}

}