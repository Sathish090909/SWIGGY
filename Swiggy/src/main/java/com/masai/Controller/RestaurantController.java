package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.Model.Customer;
import com.masai.Model.Restaurant;
import com.masai.Services.IRestaurantService;

import jakarta.validation.Valid;

public class RestaurantController {

	@Autowired
	IRestaurantService restaurant;
	@GetMapping("/Restaurants")
	public ResponseEntity<List<Restaurant>> getAllCustomers(){
		return new ResponseEntity<List<Restaurant>>(restaurant.viewAll(),HttpStatus.OK);
	}
	@GetMapping("/Restaurant/{id}")
	public ResponseEntity<Restaurant> getCustomerById(@Valid@PathVariable Long id){
		return new ResponseEntity<Restaurant>(restaurant.viewById(id),HttpStatus.OK);
	}
	@PostMapping("/RestaurantAdd")
	public ResponseEntity<Restaurant> addCustomer(@Valid@RequestBody Restaurant c){
		return new ResponseEntity<Restaurant>(restaurant.create(c),HttpStatus.OK);
	}
	@PutMapping("/RestaurantUpdate")
	public ResponseEntity<Restaurant> updateCustomer(@Valid@RequestBody Restaurant c){
		return new ResponseEntity<Restaurant>(restaurant.update(c),HttpStatus.OK);
	}
	@DeleteMapping("/RestaurantDelete/{id}")
	public ResponseEntity<Restaurant> updateCustomer(@Valid@PathVariable Long id){
		return new ResponseEntity<Restaurant>(restaurant.delete(id),HttpStatus.OK);
	}
}
