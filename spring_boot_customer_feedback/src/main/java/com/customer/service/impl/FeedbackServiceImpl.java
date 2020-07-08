package com.customer.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.customerDAO.CustomerFeedbackDAO;
import com.customer.exception.BussinessException;
import com.customer.model.CustomerFeedback;
import com.customer.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private CustomerFeedbackDAO dao;
	
	@Override
	public CustomerFeedback createCustomerFeedback(CustomerFeedback customerFeedback) {
		
		return dao.save(customerFeedback);
	}

	@Override
	public CustomerFeedback getCustomerFeedbackById(int id) throws BussinessException {
		
		if(id <= 0)
			throw new BussinessException("Invalid ID : "+id);
		CustomerFeedback customerFeedback = null;
		try {
			customerFeedback = dao.findById(id).get();
		}catch (NoSuchElementException e) {
			throw new BussinessException("No value Present for the give ID : "+id);
		}
		return customerFeedback;
	}

	@Override
	public List<CustomerFeedback> getCustomerFeedbackByEmail(String email) throws BussinessException {
		
		List<CustomerFeedback> feedbackList = null;
		feedbackList = dao.findByEmail(email);
		if(feedbackList.isEmpty())
			throw new BussinessException("No feedbacks submitted with email Id : "+email);
		return feedbackList;
	}

	@Override
	public List<CustomerFeedback> getAllCustomerFeedbacks() throws BussinessException {
		
		List<CustomerFeedback> feedbackList = null;
		feedbackList = dao.findAll();
		if(feedbackList.isEmpty())
			throw new BussinessException("No feedbacks to display");
		return feedbackList;
		
	}

	@Override
	public CustomerFeedback updateCustomerFeedback(CustomerFeedback customerFeedback) {
		
		return dao.save(customerFeedback);
	}

	@Override
	public Boolean deleteCustomerFeedbackById(int id) throws BussinessException {
		if(id <= 0)
			throw new BussinessException("Invalid ID : "+id);
		
		try{
			dao.findById(id).get();
			dao.deleteById(id);
			return true;
		}catch (Exception e) {
			throw new BussinessException("No value Present for the give ID : "+id);
		}
	}
	
}
