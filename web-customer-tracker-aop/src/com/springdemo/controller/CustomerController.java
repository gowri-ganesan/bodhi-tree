package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get customers from the service
		List<Customer> customers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers",customers);
		
		return "list-customers";
		
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		
		return "customer-form";
		
	}
	
	
	@PostMapping("/search")
	public String searchCustomers(@RequestParam("firstOrLastName") String firstOrLastName,
			Model theModel) {
		
		System.out.println("\n Request Param: first or lastName to search"+firstOrLastName);
		
		
		
		//get the customer details for the given name
		List<Customer> customers = customerService.searchCustomers(firstOrLastName);

		theModel.addAttribute("customers",customers);
		
		return "list-customers";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theModel) {
		
		//save the customer using service
		customerService.saveCustomer(theModel);
		
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, 
			Model theModel) {
		
		//get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		//send over to the form for display
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, 
			Model theModel) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
