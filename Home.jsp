<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%--out.println(session.getAttribute("myusername"));--%>

<form action="Mess" method="get">
<h1 align="center"> RUSSIAN Army Network</h1>
<%
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manohar","root","root");  
Statement stmt=con.createStatement();
String myquery="select Uname from Army where Uname not in ('"
+(String) session.getAttribute("myusername")+"')";
//(String) session.getAttribute("myusername");
System.out.println("Query: "+myquery);
ResultSet rs=stmt.executeQuery(myquery);
%>
<center>
 <select name="msguser" >
    <option>---select---- </option>
    <%while(rs.next()){ %>
    <option><%=rs.getString(1)%></option>
  <%
 }
 con.close();
 }
  catch (Exception e) {
   e.printStackTrace();
 }
%>
 </select>
</center>

<center>
Enter message here
<br>
<textarea name="message" rows="20" cols="50"></textarea>
<input type="submit" value="Back to chat">
<a href="logout">Logout</a>
</center>
</form>
</body>
</html>