package com.linzhijia.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linzhijia.boot.domain.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
    private CustomerRepository customerRepository;
	
	
	@Override
	public boolean addCustomer(Customer customer) {
		boolean boo = false;
		try{
			customerRepository.save(customer);
			boo = true;
		}catch(Exception e){
			boo = false;
			e.printStackTrace();
		}
		return boo;
	}


	@Override
	public Customer getCustomerByName(String customerName) {
		
		return customerRepository.getCustomerByCustomerName(customerName);
	}

	
}
