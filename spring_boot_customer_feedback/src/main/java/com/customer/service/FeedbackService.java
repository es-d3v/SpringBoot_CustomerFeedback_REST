package com.customer.service;

import java.util.List;


import com.customer.exception.BussinessException;
import com.customer.model.CustomerFeedback;

public interface FeedbackService {

	public CustomerFeedback createCustomerFeedback(CustomerFeedback customerFeedback);
	public CustomerFeedback getCustomerFeedbackById(int id) throws BussinessException;
	public List<CustomerFeedback> getCustomerFeedbackByEmail(String email) throws BussinessException;
	public List<CustomerFeedback> getAllCustomerFeedbacks() throws BussinessException;
	public Boolean deleteCustomerFeedbackById(int id) throws BussinessException;
	CustomerFeedback updateCustomerFeedback(CustomerFeedback customerFeedback);
}
