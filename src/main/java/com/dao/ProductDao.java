package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.beans.ProductBean;
import com.database.DBConnection;

public class ProductDao {

	public int addProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		int k=0;
		try
		{
			Connection con=DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into product_information values(?,?,?,?)");
			ps.setString(1, bean.getPid());
			ps.setString(2, bean.getPname());
			ps.setDouble(3, bean.getPrice());
			ps.setInt(4, bean.getQty());
			
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

	public List<ProductBean> viewAllProducts() {

	    List<ProductBean> bean = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	            "select pid, pname, price, qty from product_information"
	        );

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            ProductBean pb = new ProductBean();

	            pb.setPid(rs.getString(1));
	            pb.setPname(rs.getString(2));
	            pb.setPrice(rs.getDouble(3));
	            pb.setQty(rs.getInt(4));

	            bean.add(pb);
	        }

//	        System.out.println("Products fetched: " + bean.size());

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return bean;
	}
	
	public int deleteProduct(String pid)
	{
		int k=0;
		try
		{
			Connection con=DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("delete from product_information where pid=?");
			ps.setString(1, pid);
			
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

	public ProductBean getProductById(String pid) {
		// TODO Auto-generated method stub
		ProductBean bean=null;
		try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	            "select pid, pname, price, qty from product_information where pid=?"
	        );
	        ps.setString(1, pid);
	        ResultSet rs = ps.executeQuery();

	        if(rs.next()) {

	            bean=new ProductBean(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
	        }

	        

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return bean;
	}

	public int updateProduct(String pid,double newPrice,int newQty) {
	
		int k=0;
		try
		{
			Connection con=DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("update product_information set price=?, qty=? where pid=?");
			
			ps.setDouble(1, newPrice);
			ps.setInt(2, newQty);
			ps.setString(3, pid);
			
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

	public int removeQty(String pid, int qty) {
		// TODO Auto-generated method stub
		int l=0;
		try
		{
			Connection con=DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("update product_information set qty=? where pid=?");
			
			
			ps.setInt(1, qty);
			ps.setString(2, pid);
			
			l=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
		
	}

	
}
