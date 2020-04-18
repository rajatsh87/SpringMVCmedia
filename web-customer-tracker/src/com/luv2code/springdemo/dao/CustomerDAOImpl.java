package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository

public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveCustomer(Customer c1) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println(c1);
		session.saveOrUpdate(c1);
	}
	@Override
	public Customer getCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by first_name", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void deleteCustomer(int c1) {
		//deleting using query
		Session session=sessionFactory.getCurrentSession();
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", c1);
		theQuery.executeUpdate();
	}
	
	@Override
	public void addDocument(byte[] doc, int cusId) {
		System.out.println("in DAO to upload doc cusId"+cusId);
		System.out.println("doc"+doc);
	}

}
