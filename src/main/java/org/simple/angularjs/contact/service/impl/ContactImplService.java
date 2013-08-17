package org.simple.angularjs.contact.service.impl;

import org.simple.angularjs.contact.dao.interfaces.ContactDAO;
import org.simple.angularjs.contact.entity.Contact;
import org.simple.angularjs.contact.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactImplService extends GenericImplService<Contact, ContactDAO> implements ContactService {

	@Autowired
	public ContactImplService(ContactDAO dao) {
		setDao(dao);
	}

}