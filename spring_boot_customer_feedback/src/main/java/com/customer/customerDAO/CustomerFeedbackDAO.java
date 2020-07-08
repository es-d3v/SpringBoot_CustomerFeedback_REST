package com.customer.customerDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.customer.model.CustomerFeedback;

@Repository
public interface CustomerFeedbackDAO extends JpaRepository<CustomerFeedback, Integer>{

	public List<CustomerFeedback> findByEmail(String email);
}
