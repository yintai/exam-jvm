package com.linzhijia.boot.service;

import org.springframework.data.repository.CrudRepository;

import com.linzhijia.boot.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	   Customer getCustomerByCustomerName(String customerName);
}
