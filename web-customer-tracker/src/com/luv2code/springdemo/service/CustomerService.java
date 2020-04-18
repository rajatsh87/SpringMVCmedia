package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {
	void saveCustomer(Customer c1);
	Customer getCustomer(int id);
	List<Customer> getCustomers();
	void deleteCustomer(int cusId);
	void addDocument(byte[] doc,int cusId);
}
