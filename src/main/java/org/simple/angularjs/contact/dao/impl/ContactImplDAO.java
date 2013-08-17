package org.simple.angularjs.contact.dao.impl;

import org.simple.angularjs.contact.dao.interfaces.ContactDAO;
import org.simple.angularjs.contact.entity.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactImplDAO extends GenericHibernateDAO<Contact> implements ContactDAO {

	public ContactImplDAO() {
		super(Contact.class);
	}

}