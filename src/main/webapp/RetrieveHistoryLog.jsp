<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
    String userName = (String)session.getAttribute("name");
	String driverName = "com.mysql.jdbc.Driver";	
	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	 if(null == userName)
			response.sendRedirect("GiftcardHomePage.jsp");
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="cache-control" content="max-age=0" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="pragma" content="no-cache" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Purchase log</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        <script src="assets/js/jquery.dataTables.min.js"></script>
        <script src="assets/js/dataTables.bootstrap.min.js"></script>
		<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<script type="text/javascript">$(document).ready(function() {$('#example').DataTable();} );</script>
</head>
<body>		
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header"><a class="navbar-brand" href="#">E-Giftcard</a></div>
				<ul class="nav navbar-nav">
					<li><a href="LoggedIn.jsp">Dashboard</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"> 
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" >
								<span class="glyphicon glyphicon-user"> <%=session.getAttribute("name")%></span>
							</a>
							<ul class="dropdown-menu " id="myDropdown">
     									<li>
											<form action ="LogoutUser" method="get" >
												<P align="center">
													<button type="submit" class="btn btn-info">
														<span class="glyphicon glyphicon-log-out">  Logout </span>
													</button>
												</P>
											</form>
										</li>
										<li><P align="center"><a href="RetrieveHistoryLog.jsp"><button type="submit" class="btn btn-info" > Purchase History </button></a></P></li>
    						</ul>
    					</li>
    				</ul>
			</div>
		</nav> 	
<div class="container">
	<div class="row">
		<section class="content">
			<div class="col-md-10 col-md-offset-1" align="center">
				<div class="panel panel-default">
				<h4 style="color:green" align="center"> <%=session.getAttribute("name")%>'s Purchase History </h4>
					<div class="panel-body">
						<div class="table-container">
							<table id="example" class="table table-bordered table-hover table-filter">
								<thead>
									  <tr>
									     <th>Purchase_id</th>
									     <th>Company name</th>
									     <th>Coupon Purchased</th>
									     <th>Purchased date</th>
									  </tr>
								</thead>
								<tbody>
								<%
								try{	
								connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/websit_giftcard","root","manojmore");
								PreparedStatement getPurchaseLog=connection.prepareStatement("select * from `websit_giftcard`.`purchase_log` where (transaction_id=(select iduser_amount_transcation from `websit_giftcard`.`user_amount_transcation` where(user_id=(select user_id from `websit_giftcard`.`user_registration` where email=? ))))");
								getPurchaseLog.setString(1,userName);
								resultSet = getPurchaseLog.executeQuery();
									while(resultSet.next()){
								%>
									<tr>
										<td><%=resultSet.getString("purchase_id") %></td>
										<td><%=resultSet.getString("website_name") %></td>
										<td><%=resultSet.getString("coupon_purchased") %></td>
										<td><%=resultSet.getString("purchase_date") %></td>
									</tr>
								<%		
									}
								} catch (Exception e) {
									e.printStackTrace();
									}
								%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</div>	

<footer class="container-fluid text-center">
  <p style="color:white">Copyright © 2016 by Online Coupon Store.All Rights Reserved.</p>  
  <div class="container-fluid" align = "center">
		<a href="http://www.linkedin.com" title="linkedin" target="_blank">
			<i class="fa fa-linkedin"></i></a>
		<a href="https://www.facebook.com" title="facebook" target="_blank">
			<i class="fa fa-facebook"></i></a>
		<a href="https://www.twitter.com" title="twitter" target="_blank">
			<i class="fa fa-twitter"></i></a>
		<a href="https://www.gmail.com">
			<i class="fa fa-envelope"></i></a>
		<a href="https://www.skype.com">
			<i class="fa fa-skype"></i></a>
</div>
</footer>
<div class="container" align = "center"> 
<p style="color:white">Online Coupon Store Partners.</p>  
  <span class="label label-default">Amazon</span>
  <span class="label label-primary">Flipkart</span>
  <span class="label label-success">Myntra</span>
  <span class="label label-info">Ebay</span>
  <span class="label label-warning">Alibaba</span>
  <span class="label label-danger">Paytm</span>
</div>	
</body>
</html>