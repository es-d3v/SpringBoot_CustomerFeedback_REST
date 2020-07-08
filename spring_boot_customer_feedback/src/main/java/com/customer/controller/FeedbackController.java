package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.exception.BussinessException;
import com.customer.model.CustomerFeedback;
import com.customer.service.FeedbackService;

@RestController
public class FeedbackController  {

	@Autowired
	private FeedbackService service;
	
	private MultiValueMap<String,String> map; 
	
	@PostMapping("/feedback")
	public CustomerFeedback createCustomerFeedback(@RequestBody CustomerFeedback customerFeedback) {
		
		return service.createCustomerFeedback(customerFeedback);
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<CustomerFeedback> getCustomerFeedbackById(@PathVariable("id") int id) {

		try {
			return new ResponseEntity<CustomerFeedback>(service.getCustomerFeedbackById(id),HttpStatus.OK);
		} catch (BussinessException e) {
			map = new LinkedMultiValueMap<>();
			map.add("message",e.getMessage());
			return new ResponseEntity<CustomerFeedback>(null, map, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/feedback/email/{email}")
	public ResponseEntity<List<CustomerFeedback>> getCustomerFeedbackByEmail(@PathVariable("email") String email) {

		try {
			return new ResponseEntity<List<CustomerFeedback>>(service.getCustomerFeedbackByEmail(email),HttpStatus.OK);
		} catch (BussinessException e) {
			map = new LinkedMultiValueMap<>();
			map.add("message",e.getMessage());
			return new ResponseEntity<List<CustomerFeedback>>(null,map,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<CustomerFeedback>> getAllCustomerFeedbacks() {
	
		try {
			return new ResponseEntity<List<CustomerFeedback>>(service.getAllCustomerFeedbacks(),HttpStatus.OK);
		} catch (BussinessException e) {
			map =new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<List<CustomerFeedback>>(null,map,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/feedback")
	public CustomerFeedback updateCustomerFeedback(CustomerFeedback customerFeedback) {
		return service.updateCustomerFeedback(customerFeedback);
	}
	
	@DeleteMapping("/feedback/{id}")
	public ResponseEntity<Boolean> deleteCustomerFeedbackById(@PathVariable("id")int id) {
			
		try {
			return new ResponseEntity<Boolean>(service.deleteCustomerFeedbackById(id),HttpStatus.OK);
		} catch (BussinessException e) {
			map = new LinkedMultiValueMap<>();
			map.add("message",e.getMessage());
			return new ResponseEntity<Boolean>(null,map,HttpStatus.NOT_FOUND);
		}
	}
}
