package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO obj;
	
	@Override
	public List<Customer> getCustomers() {
		
		List<Customer> cus=obj.getCustomers();
		return cus;
	}

	@Override
	public void saveCustomer(Customer c1) {
		obj.saveCustomer(c1);
	}

	@Override
	public Customer getCustomer(int id) {
		return obj.getCustomer(id);
	}


	@Override
	public void deleteCustomer(int c1) {
		obj.deleteCustomer(c1);
	}

	@Override
	public void addDocument(byte[] doc, int cusId) {
		obj.addDocument(doc, cusId);
	}

}
