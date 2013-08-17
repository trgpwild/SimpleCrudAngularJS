package org.simple.angularjs.contact.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.simple.angularjs.contact.entity.Contact;
import org.simple.angularjs.contact.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> list() throws JsonGenerationException, JsonMappingException, IOException {
		return contactService.list();
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Contact read(@PathParam("id") Long id) {
		Contact contact = contactService.get(id);
		if (contact == null) {
			throw new WebApplicationException(404);
		}
		return contact;
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Contact create(Contact contact) {
		contactService.save(contact);
		return contact;
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Contact update(@PathParam("id") Long id, Contact contact) {
		contactService.save(contact);
		return contact;
	}


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		contactService.delete(
			contactService.get(id)
		);
	}

}