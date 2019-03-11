package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
		
		//need to inject customer dao
		@Autowired
		private CustomerDAO customerDAO;
		
		
		@Override
		@Transactional
		public List<Customer> getCustomers() {
		
			return customerDAO.getCustomers();
		}
		
		@Override
		@Transactional
		public void saveCustomer(Customer customer) {
			
			customerDAO.saveCustomer(customer);
			return;
			
		}

		@Override
		@Transactional
		public Customer getCustomer(int theId) {
			Customer customer = customerDAO.getCustomer(theId);
			return customer;
		}

		@Override
		@Transactional
		public void deleteCustomer(int theId) {
			customerDAO.deleteCustomer(theId);
			return;
			
		}

		@Override
		@Transactional
		public List<Customer> searchCustomers(String firstOrLastName) {
			List<Customer> customers = customerDAO.searchCustomers(firstOrLastName);
			return customers;
		}

}
