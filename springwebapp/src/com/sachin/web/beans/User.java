package com.sachin.web.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@NotBlank(message ="Username cannot be blank")
	@Size(min=8,max=15)
	@Pattern(regexp="^\\w{8,}$",message = "username can only consist of numbers,letters,underscore")
	private String username;
	
	
	@Pattern(regexp=".*\\@.*\\..*", message= "Its  not a valid mail id")
	private String email;
	
	@NotBlank(message="passwored cannot be blank")
	@Pattern(regexp="^\\S+$",message="write a proper password")
	@Size(min=5,max=20,message="password must contain min 4 character ")
	private String password;
	private boolean enabled = false;
	private String authority;
	
	public User() {
		
	}
	public User(String username, String email, String password, boolean enabled, String authority) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
