package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.beans.AdminBean;
import com.beans.CustomerBean;
import com.database.DBConnection;

public class CustomerDao {

	public int insertCustomerInfo(CustomerBean cb) {
		
		int rowCount=0;
		try
		{
			Connection con=DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into customer_information values(?,?,?,?,?)");
			
			ps.setString(1, cb.getCid());
			ps.setString(2, cb.getCname());
			ps.setString(3, cb.getPwd());
			ps.setString(4, cb.getMailid());
			ps.setLong(5, cb.getPhone());
			
			rowCount = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowCount;
		
	}

	public CustomerBean customerLogin(String mailid, String pwd) {
		// TODO Auto-generated method stub
		CustomerBean bean=null;
		
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from customer_information where mailid=? and pwd=?");
			ps.setString(1, mailid);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
								
				bean=new CustomerBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5));//or using setter
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return bean;
	}

}
