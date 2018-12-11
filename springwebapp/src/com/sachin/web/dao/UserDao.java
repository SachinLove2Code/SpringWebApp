package com.sachin.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sachin.web.beans.User;

@Component("userDao")
public class UserDao implements IUser{

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	public UserDao() {
		
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Override
	@Transactional
	public boolean insert(User user) {
		 
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("enabled", user.isEnabled());
		params.addValue("email", user.getEmail());
		params.addValue("authority", user.getAuthority());
		
		jdbc.update("insert into users (username, password, enabled, email) values(:username,:password,:enabled,:email)", params);
		
		return jdbc.update("insert into authorities (username, authority) values(:username, :authority)", params) == 1;
		
	}

	@Override
	public boolean existsUsername(String username) {
		
		return jdbc.queryForObject("select count(*) from users where username=:username ", 
				new MapSqlParameterSource("username", username), Integer.class)== 1;
	}

	@Override
	public List<User> getUsers() {
		
		return jdbc.query("select * from users,authorities where users.username = authorities.username", BeanPropertyRowMapper.newInstance(User.class));
	}

	

}
