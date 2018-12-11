package com.sachin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.sachin.web.beans.CustomerDetailsBean;
import com.sachin.web.dao.CustomerDao;
import com.sachin.web.dao.ICustomerDetails;

@Service("customerService")
public class CustomerService {

/*	private CustomerDao customerDAO;
	
	@Autowired
	public void setCustomerDAO(CustomerDao customerDAO) {
		this.customerDAO = customerDAO;
	}*/
	
	
	private ICustomerDetails iCustomerDetails = new CustomerDao();
	
	@Autowired
	public void setiCustomerDetails(ICustomerDetails iCustomerDetails) {
		this.iCustomerDetails = iCustomerDetails;
	}

	public List<CustomerDetailsBean> getCustomerList(){
		return iCustomerDetails.getAllCustomerDetails();
	}

	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public void insertCustomer(CustomerDetailsBean customerBean) {
		iCustomerDetails.insert(customerBean);
		
	}
}
