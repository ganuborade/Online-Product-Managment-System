package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.beans.AdminBean;
import com.database.DBConnection;

public class AdminDao {

	public int adminRegister(AdminBean ab) {
		// TODO Auto-generated method stub
		int rowCount=0;
		try
		{
			Connection con=DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into admin_information values(?,?,?,?,?,?)");
			
			ps.setString(1, ab.getAname());
			ps.setString(2, ab.getPwd());
			ps.setString(3, ab.getFname());
			ps.setString(4, ab.getLname());
			ps.setString(5, ab.getMailid());
			ps.setLong(6, ab.getPhone());
			
			rowCount = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowCount;
	}

	public AdminBean adminLogin(String aName, String pwd) {
		// TODO Auto-generated method stub
		AdminBean bean=null;
		
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin_information where aname=? and pwd=?");
			ps.setString(1, aName);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				
				
				bean=new AdminBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6));//or using setter
				
//				
//				bean.setAname(rs.getString(1));
//				bean.setPwd(rs.getString(2));
//				bean.setFname(rs.getString(3));
//				bean.setLname(rs.getString(4));
//				bean.setMailid(rs.getString(5));
//				bean.setPhone(rs.getLong(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return bean;
	}
}
