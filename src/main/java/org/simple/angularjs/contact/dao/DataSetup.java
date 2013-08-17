package org.simple.angularjs.contact.dao;

import org.simple.angularjs.contact.entity.Contact;
import org.simple.angularjs.contact.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

public class DataSetup {

	@Autowired
	private ContactService contactService;

	public void setup() {

		Contact contact = new Contact();
		
		contact.setName("Thiago Pinto");
		contact.setPhone("015-11111111");
		
		contactService.save(contact);

		contact = new Contact();
		
		contact.setName("Jose Ribeiro");
		contact.setPhone("015-11111111");
		
		contactService.save(contact);

		contact = new Contact();
		
		contact.setName("Camilo Lopes");
		contact.setPhone("015-11111111");
		
		contactService.save(contact);

	}

}