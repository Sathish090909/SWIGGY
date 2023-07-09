package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Customer;
import com.masai.Services.ICustomerSevice;

import jakarta.validation.Valid;

@RestController	
public class CustomerController {

	@Autowired
	ICustomerSevice customerService;
	
	@GetMapping("/Customers")
	public ResponseEntity<Page<Customer>> getAllCustomers(){
		return new ResponseEntity<Page<Customer>>(customerService.viewAll(),HttpStatus.OK);
	}
	@GetMapping("/Customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@Valid@PathVariable Long id){
		return new ResponseEntity<Customer>(customerService.viewCustomerById(id),HttpStatus.OK);
	}
	@PostMapping("/CustomerAdd")
	public ResponseEntity<Customer> addCustomer(@Valid@RequestBody Customer c){
		return new ResponseEntity<Customer>(customerService.AddCustomer(c),HttpStatus.OK);
	}
	@PutMapping("/CustomerUpdate")
	public ResponseEntity<Customer> updateCustomer(@Valid@RequestBody Customer c){
		return new ResponseEntity<Customer>(customerService.UpdateCustomer(c),HttpStatus.OK);
	}
	@DeleteMapping("/CustomerDelete/{id}")
	public ResponseEntity<Customer> updateCustomer(@Valid@PathVariable Long id){
		return new ResponseEntity<Customer>(customerService.DeleteCustomer(id),HttpStatus.OK);
	}
	
	
}
