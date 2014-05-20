package com.dream.smartrans.dao;

import java.util.List;

import com.dream.smartrans.po.Customer;

public interface CustomerDao {

	Customer findByUserId(String userId);

	Customer findById(String customerId);

	String update(Customer customer);

	String delete(String customerId);

	String insert(Customer customer);

	List<Customer> findAll();

}
