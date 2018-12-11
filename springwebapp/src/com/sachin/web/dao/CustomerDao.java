package com.sachin.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import com.sachin.web.beans.CustomerDetailsBean;

@Component("customerDao")
public class CustomerDao implements ICustomerDetails{

	private NamedParameterJdbcTemplate jdbc;
	
	public CustomerDao() {
		System.out.println("Customer Dao Successfully Created");
	}
		
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate (jdbc);
	}



	@Override
	public List<CustomerDetailsBean> getAllCustomerDetails() {
		return jdbc.query("Select * from customerdetails", new RowMapper<CustomerDetailsBean>() {
			@Override
			public CustomerDetailsBean mapRow(ResultSet rs, int arg1)
					throws SQLException {
				CustomerDetailsBean custBean = new CustomerDetailsBean();
				
				custBean.setCustId(rs.getInt("idCustomerDetails"));
				custBean.setCustName(rs.getString("CustName"));
				custBean.setCustEmail(rs.getString("CustEmail"));
				custBean.setCity(rs.getString("CustCity"));
				
				
				return custBean;
			}
		});
	}

	@Override
	public boolean insert(CustomerDetailsBean customerBean) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(customerBean);
		return jdbc.update("insert into customerDetails (CustName,CustEmail,CustCity) values(:custName,:custEmail,:city)", params)==1;
	}
	@Override
	public int[] insertBatch(List<CustomerDetailsBean> customerBean) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(customerBean.toArray());
		return jdbc.batchUpdate("insert into customerDetails (CustName,CustEmail,CustCity) values (:custName,:custEmail,:city", params);
	}
}
