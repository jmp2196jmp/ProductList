package com.face.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.face.bo.ProductList;

public class PDUtils {

	public static void insert(Connection con, ProductList pl) throws SQLException {//To insert into DB
		 
		String  productId=pl.getProductId();
		String productName=pl.getProductName();
		String  quantity=pl.getQuantity();
		String  price=pl.getPrice();
		
		/*
		 * System.out.println( productId); System.out.println( productName);
		 * System.out.println( quantity); System.out.println( price);
		 */
		
		String sql="insert into product_list(product_id,product_name,quantity,price) values('"+productId+"','"+productName+"','"+quantity+"','"+price+"')";		
		 PreparedStatement ps = con.prepareStatement(sql);
		 int rs=ps.executeUpdate(sql);
	}
	public static ArrayList<String>  display(Connection con) throws SQLException {//To print in JSP page
		
		ArrayList<String> array=new ArrayList<String>();
		
		String  query="select * from product_list";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rt=ps.executeQuery(query);
		while(rt.next()) {
			array.add(rt.getString("product_id"));
			array.add(rt.getString("product_name"));
			array.add(rt.getString("quantity"));
			array.add(rt.getString("price"));
		}
		
		return array;
		
	}
	

}
