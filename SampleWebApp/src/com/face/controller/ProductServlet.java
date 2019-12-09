package com.face.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.face.bo.ProductList;
//import com.face.dao.DBUtils;
import com.face.dao.MyUtils;
import com.face.dao.PDUtils;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Welcome to ProductServlet");
		RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productListView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String productName = request.getParameter("productName");
	       String productId = request.getParameter("productId");
	       String quantity=request.getParameter("quantity");
	       String price=request.getParameter("price");
	       System.out.println(productName);
	       System.out.println(productId);
	       System.out.println(quantity);
	       System.out.println(price);
	       
	       
	       //DBUtils db=new DBUtils();
	       ProductList pl=new ProductList();
	       pl.setProductId(productId);
	       pl.setProductName(productName);
	       pl.setQuantity(quantity);
	       pl.setPrice(price);
	       
	       Connection con=MyUtils.getStoredConnection(request);
	       try {
			PDUtils.insert(con,pl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	       //To print product details from DB
	       
	      ArrayList<String> array=new ArrayList<String>();
	       try {
			array=PDUtils.display(con);
			System.out.println(array);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	       request.setAttribute("array", array);
	        // Forward to /WEB-INF/views/productInfoView.jsp
	        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productInfoView.jsp");
	        dispatcher.forward(request, response);
	        
	      
	     //doGet(request, response);      
	}

}
