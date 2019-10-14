package my.learning.springboot.swagger.springbootswagger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

	ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();

	@GetMapping("/{id}")
	@ApiOperation(value="Find Contacts by Id",
	notes="Provide an id to look up specifc contact from the Address Book",
	response=Contact.class)
	public Contact getContact(@ApiParam(value="Id value for the contact you need to retrieve",required=true)
			@PathVariable String id) {
		return contacts.get(id);
	}

	@GetMapping("/")
	@ApiOperation(value="Find All Contacts Details",
	notes="Find All Contacts Details from the Address Book",
	response=Contact.class)
	public List<Contact> getAllContacts() {
		return new ArrayList<Contact>(contacts.values());
	}

	@PostMapping("/")
	@ApiOperation(value="Add new Contact",
	notes="Add the new Contact to the Address Book",
	response=Contact.class)
	public @ResponseBody Contact addContact(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;
	}
}
