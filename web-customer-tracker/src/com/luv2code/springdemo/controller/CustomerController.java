//package com.luv2code.springdemo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.luv2code.springdemo.dao.CustomerDAO;
//import com.luv2code.springdemo.entity.Customer;
//
//@Controller
//@RequestMapping("/customer")
//public class CustomerController {
//	@Autowired 
//	private CustomerDAO daoObj;
//	@RequestMapping("/list")
//	 public String listCustomers(Model theModel) {
//		List<Customer>customer=daoObj.getCustomers();
//		//add the customers to model
//		theModel.addAttribute("customers",customer);
//		return "list-customers";
//	}
//}



package com.luv2code.springdemo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.DocumentDetails;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
		//System.out.println("Customers:"+theCustomers);
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//Customer cus=new Customer();
		DocumentDetails docDetail=new DocumentDetails();
		theModel.addAttribute("customer", docDetail);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute ("customer") DocumentDetails doc) throws IOException {
		
//		System.out.println("Customer:"+theCustomer);
//		customerService.saveCustomer(theCustomer);
//		
//		// get customers from the dao
//		List<Customer> theCustomers = customerService.getCustomers();
		
		Customer cus=new Customer();
		MultipartFile multipart=doc.getFile();
		System.out.println(doc);
		cus.setFirstName(doc.getFirstName());
		cus.setLastName(doc.getLastName());
		cus.setEmail(doc.getEmail());
		cus.setDocument(multipart.getBytes());
		
		return "redirect:/customer/list";
	} 
	
	@GetMapping("/showFormForUpdate")
	public String showFormUpdate(@RequestParam("customerId") int cusId,Model theModel) {
		Customer cus=customerService.getCustomer(cusId);
		//System.out.println("CUSTOMER by ID:"+cusId);
		//System.out.println(cus);
		theModel.addAttribute("customer",cus);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int cusId) {
		customerService.deleteCustomer(cusId);
		return "redirect:/customer/list";
	}
	
}


