package com.luv2code.springdemo.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
@Repository
public interface CustomerDAO {
	void saveCustomer(Customer c1);
	Customer getCustomer(int id);
	List<Customer> getCustomers();
	void deleteCustomer(int c1);
	void addDocument(byte[] doc,int cusId);
}
