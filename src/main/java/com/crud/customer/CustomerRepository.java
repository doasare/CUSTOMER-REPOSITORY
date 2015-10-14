package com.crud.customer;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Random;

public class CustomerRepository {

	private final Map<Long, Customer> customersRecords = new ConcurrentHashMap<Long, Customer>();

	//generate unique id
	public void create(String fName, String lName, String email, String phone) {
		Random rand = new Random();
		Long n = rand.nextLong() * (900000L - 100000L) + 100000L;
		
		while (customersRecords.containsKey(n)){
			n = rand.nextLong() * (900000L - 100000L) + 100000L;
		}
		Long id = Math.abs(n);
		Customer newCustomer = new Customer(id,fName, lName, email, phone);
		customersRecords.put(id, newCustomer);

	}
	
	public Collection<Customer> list() {
		return customersRecords.values();
	}

	public Customer find(Long id) {
		return customersRecords.get(id);
	}
	public Boolean delete(Long id){
		if (customersRecords.containsKey(id)){
			customersRecords.remove(id);
			return true;
		} 
		return false;
	}
	public Boolean update(Long id, String fName, String lName, String email, String phone){
		if (customersRecords.containsKey(id)) {
			Customer customer = new Customer(id,fName, lName, email, phone);
			customersRecords.put(id, customer);
			return true;
		}
			return false;

	}


}
