package com.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers() {
		

		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		//execute query and get results
		List<Customer> customers= theQuery.getResultList();
		
		//return the results
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer, if customer is new or update the customer, if existing
		currentSession.saveOrUpdate(customer);
		
		return;
	}
	
	@Override
	public Customer getCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrieve the customer from DB using id
		Customer theCustomer= currentSession.get(Customer.class, theId);
		
		//return the result
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//now delete the customer
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId",theId);
		theQuery.executeUpdate();
		return;
		
	}

	@Override
	public List<Customer> searchCustomers(String firstOrLastName) {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		System.out.println("\n Searching for customers with name like: "+firstOrLastName);
		Query theQuery = null; 
				
		//now retrieve the customer from DB using first or last name
		if (firstOrLastName != null && firstOrLastName.trim().length() > 0) {
		theQuery = currentSession.createQuery("from Customer where firstName like:theName or lastName like:theName",Customer.class);
		theQuery.setParameter("theName","%"+firstOrLastName+"%");
		//execute query and get results
		}
		else {
			theQuery = currentSession.createQuery("from Customer",Customer.class);
		}
		List<Customer> customers= theQuery.getResultList();
		
				
		//return the result
		return customers;
		
	}
	
}
