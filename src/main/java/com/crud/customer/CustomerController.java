package com.crud.customer;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class CustomerController {

	//singleton
	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	//Creating a single customer
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ResponseEntity<Collection> create(
            @RequestParam(value = "firstName", required = true) String fName,
            @RequestParam(value = "lastName", required = true) String lName,
            @RequestParam(value = "email", required = false) String email ,
            @RequestParam(value = "phone", required = false) String phone
            ){
		customerRepository.create(fName, lName, email, phone);
		return new ResponseEntity<Collection>(customerRepository.list(), HttpStatus.OK);
	}

	//Listing all customers
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ResponseEntity<Collection> list(
            ){
	
		return new ResponseEntity<Collection>(this.customerRepository.list(), HttpStatus.OK);
	}

	//Reading a single customer
	@RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
	public ResponseEntity<Customer> listId(
            @PathVariable("id") Long id){
	
		return new ResponseEntity<Customer>(this.customerRepository.find(id), HttpStatus.OK);
	}
	
	//Deleting a single customer
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity<String> deleteId(
            @PathVariable("id") Long id){

		String response = id + " removed: "+ this.customerRepository.delete(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	//Updating a single customer
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity<String> update(
			@PathVariable("id") Long id,
            @RequestParam(value = "firstName", required = true) String fName,
            @RequestParam(value = "lastName", required = true) String lName,
            @RequestParam(value = "email", required = false) String email ,
            @RequestParam(value = "phone", required = false) String phone
            ){

		String response = id + " updated: "+ this.customerRepository.update(id,fName, lName, email, phone);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}





}
