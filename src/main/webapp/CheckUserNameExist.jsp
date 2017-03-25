<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%try{
	  Class.forName("com.mysql.jdbc.Driver");
      Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/websit_giftcard","root","manojmore");
      PreparedStatement ps = con.prepareStatement("SELECT  * FROM `websit_giftcard`.`user_registration` where email=?");
      ps.setString(1,request.getParameter("username"));
      ResultSet res = ps.executeQuery();
      if(res.first())
      	out.print("<font color='red'>User Name already exists</font>");
      else
       	out.print("Welcome to giftcard port");
      }catch (Exception e){
            System.out.println(e);  
      }
%>