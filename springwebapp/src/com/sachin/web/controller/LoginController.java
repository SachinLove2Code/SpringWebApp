package com.sachin.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sachin.web.beans.User;
import com.sachin.web.service.UserService;

@Controller
public class LoginController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping(value = "/loggedout")
	public String showLogout() {
		return "loggedout";
	} 
	
	@RequestMapping("/logout")
    public String logoutUrl(){
        return "logout";
    }
	
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		
		
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin";
	}
	
	
	@RequestMapping("/addnewaccount")
	public String showAddAccount(Model model) {
		model.addAttribute("user", new User());
		return "addnewaccount";
	}

	@RequestMapping(value = "/accountcreated", method = RequestMethod.POST)
	public String showAccountCreated(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "addnewaccount";
		}

		if (userService.exists(user.getUsername())) {
			System.out.println("Duplicate Username find");
			result.rejectValue("username", "DuplicateKey.user.username");
					
			return "addnewaccount";
		} else {
			user.setEnabled(true);
			user.setAuthority("ROLE_USER");
			userService.insertUser(user);
		}
		/*
		 * try { userService.insertUser(user); } catch (DuplicateKeyException e)
		 * { result.rejectValue("username", "DuplicateKey.user.username",
		 * "This username already exists!"); return "addnewaccount";
		 * //System.out.println(e.getClass()); }
		 */

		return "doaccountcreated";
	}
}
