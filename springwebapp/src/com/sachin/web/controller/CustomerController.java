package com.sachin.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sachin.web.beans.CustomerDetailsBean;
import com.sachin.web.service.CustomerService;

@Controller
public class CustomerController {
	
	/*@RequestMapping("/")
	public String showHome() {
		System.out.println("This is offer controller");
		return "home";
	}*/
/*	@RequestMapping("/")
	public String showHome(HttpSession session) {
		session.setAttribute("name", "Rally for river");
		return "home";
	}*/
	
	/*@RequestMapping("/")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");
		Map<String,Object> model = mv.getModel();
		model.put("name", "Go For Rally");
		return mv;
		
	}*/
	
	private CustomerService customerService;  
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/customers")
	public String showCustomers(Model model) {
	
		List<CustomerDetailsBean> custlist = customerService.getCustomerList();
		model.addAttribute("custlist", custlist);
		return "customers";
		
	}
	
	@RequestMapping("/addcustomer")
	public String addCustomer(Model model) {
	
		model.addAttribute("customerDetailsBean", new CustomerDetailsBean());
		
		return "addcustomer";
		
	}

	@RequestMapping(value = "/doaddcustomer" ,method = RequestMethod.POST)
	public String doAddCustomer(Model model, @Valid CustomerDetailsBean customerBean , BindingResult result) {
	
		if(result.hasErrors()) {
			/*List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError.getDefaultMessage());
			}*/
			
			return "addcustomer";
		} 
		
		customerService.insertCustomer(customerBean);
		return "customercreated";
		
	}
}
