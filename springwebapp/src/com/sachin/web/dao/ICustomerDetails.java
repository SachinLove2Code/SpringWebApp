package com.sachin.web.dao;

import java.util.List;

import com.sachin.web.beans.CustomerDetailsBean;

public interface ICustomerDetails {

	List<CustomerDetailsBean> getAllCustomerDetails();
	
	boolean insert(CustomerDetailsBean customerBean);
	
    int[] insertBatch(List<CustomerDetailsBean> customerBean);
}
