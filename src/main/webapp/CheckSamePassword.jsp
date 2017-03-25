<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<% 
	String newpass = request.getParameter("newpass");
	String confirmpass=request.getParameter("confirmpass");
	if(newpass.equals(confirmpass))
		  out.print("Password Matching");
      else
    	  out.print("<font color='red'>Password Not Matching</font>");
%>