<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Hi
 <%out.println(session.getAttribute("myusername")); %>
<br> Welcome to Chat
 </h2><br><hr>
<%
try
	   {
		   Class.forName("com.mysql.jdbc.Driver");  
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manohar","root","root");  
		   Statement stmt=con.createStatement();
		   String myquery="select * from Message";
		   ResultSet rs=stmt.executeQuery(myquery);
		   while(rs.next())
		   {
			 %><br><%out.println(rs.getString(2));%>>>>>
			  <%out.println(rs.getString(3));
		   }
		   con.close();
	   }
	    catch (Exception e) {
	     e.printStackTrace();
	   }

%>





 
</body>
<hr>
<br><br><br>
<a href="Home.jsp">Send Message</a> 
</html>