<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
  <%@page import="java.util.Iterator"%>
  <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product info</title>
</head>
 <body>
 <jsp:include page="_header.jsp"></jsp:include>
   <%-- <jsp:include page="_menu.jsp"></jsp:include> --%>
    <h1>  product details</h1>
    <div>
   <table style="width:100%; text-align:center;">
   <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Quantity</th>
   <th>Price</th>
   </tr>
    <%Iterator itr;%>
      <% List data= (List)request.getAttribute("array");
           for (itr=data.iterator(); itr.hasNext(); )
               {
           %>
           <tr>
             <td><input type="text"   name="productId" value= "<%=itr.next()%>" style="border:none; text-align:center"/></td>
              <td><%=itr.next()%></td>
               <td><%=itr.next()%></td>
              <td><%=itr.next()%></td>
              <form action="${pageContext.request.contextPath}/edit" method="post">
              <td><input type="submit" value="Edit" /></td>
              </form>
              <form action="${pageContext.request.contextPath}/delete" method="post">
              <td><input type="submit" value="Delete" /></td>
              </form>
             </tr>
             <%
             }
             %>
             
       </table>
 </div>
   <jsp:include page="_footer.jsp"></jsp:include>
 </body>
</html>



