<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
  <%@page import="java.util.Iterator"%>
  <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product Insert</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
  <%--  <jsp:include page="_menu.jsp"></jsp:include> --%>
   <h3>product Page</h3>
<form action="${pageContext.request.contextPath}/product" method="post">
<table border="0">
          <tr>
            <td>Product ID</td>
            <td><input type="text" name="productId" value= "${user.productId}" /> </td>
            </tr>
            
           <tr>
           <td>Product Name</td>
           <td><input type="text" name="productName" value= "${user.productName}" /> </td>
           </tr>
           <tr>
           <td>Quantity</td>
           <td><input type="text" name="quantity" value= "${user.quantity}"/></td> 
           </tr>
           <tr>
           <td>Price</td>
           <td><input type="text" name="price" value= "${user.price}"/></td> 
           </tr>
           <tr>
              <td colspan ="2">
                 <input type="submit" value="Submit" />
                 <a href="${pageContext.request.contextPath}/">Cancel</a>
              </td>
           </tr>
        </table>
</form>
</body>
</html>