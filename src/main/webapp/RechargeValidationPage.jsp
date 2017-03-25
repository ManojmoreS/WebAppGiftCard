<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
String userName = (String)session.getAttribute("name");
if(null == userName)
	response.sendRedirect("GiftcardHomePage.jsp");
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>E-Gift Cards Registration Form</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/scripts.js"></script>
		<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<style>.carousel-inner > .item > img,.carousel-inner > .item > a > img{width: 60%;margin: auto;}</style>
    	<script type="text/javascript">
				function loadmodalitem1(){$("#myModalitem1").modal();}
				function loadmodalitem2(){$("#myModalitem2").modal();}
				function loadmodalitem3(){$("#myModalitem3").modal();}
				function loadmodalitem4(){$("#myModalitem4").modal();}
				function loadmodalitem5(){$("#myModalitem5").modal();}
				function loadmodalitem6(){$("#myModalitem6").modal();}
				function loadmodalrecharge(){$("#myModalrecharge").modal();}
				function modalrecharge1() {$("#myModalitem1").modal("hide");$("#myModalrecharge").modal();}
				function modalrecharge2() {$("#myModalitem2").modal("hide");$("#myModalrecharge").modal();}
				function modalrecharge3() {$("#myModalitem3").modal("hide");$("#myModalrecharge").modal();}
				function modalrecharge4() {$("#myModalitem4").modal("hide");$("#myModalrecharge").modal();}
				function modalrecharge5() {$("#myModalitem5").modal("hide");$("#myModalrecharge").modal();}
				function modalrecharge6() {$("#myModalitem6").modal("hide");$("#myModalrecharge").modal();}
				function checkSession(){setTimeout("backButtonOverrideBody()", 1);}function backButtonOverrideBody(){try { history.forward();} catch (e) {}setTimeout("backButtonOverrideBody()",1);}
				$(document).ready(function(){$('[data-toggle="tooltip"]').tooltip();});
				function showDialog3() {$("#myverifycode").modal();}
		</script>
    </head>
    <body onload="showDialog3()">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header"><a class="navbar-brand" href="GiftcardHomePage.jsp">E-Giftcard</a></div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="GiftcardHomePage.jsp">Home</a></li>
					<li><a href="#">yet to add</a></li>
					<li><a href="#" onclick="loadmodalrecharge()">Recharge</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><ul class="nav pull-right">
								<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span style="color:white" class="glyphicon glyphicon-user"> <%=session.getAttribute("name")%> </span> </a>
									<ul class="dropdown-menu">
										<li><a href="#">Profile</a></li>
										<li><form action ="LogoutUser" method="get"><button type="submit" class="btn btn-info" ><span class="glyphicon glyphicon-log-out"> Logout </span></button></form>
										</li>
										<li><P align="center"><a href="RetrieveHistoryLog.jsp"><button type="submit" class="btn btn-info" > Purchase History </button></a></P></li>
									</ul>
								</li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>   
  <div class="row">
    <div class="col-sm-2" data-toggle="tooltip" title="click here for offer!">
      <div class="panel panel-primary" onclick="loadmodalitem1()">
        <div class="panel-heading">Flat 10% pay back on Amazon coupon</div>
        <div class="panel-body"><img src="img/amazon_logo.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Coupons are valid for a limited time only. Amazon reserves the right to modify or cancel coupons at any time</div>
      </div>
    </div>
    <div class="col-sm-2" data-toggle="tooltip" title="click here for offer!"> 
      <div class="panel panel-primary" onclick="loadmodalitem2()">
        <div class="panel-heading">Flat 15% pay back on Flipkart coupon</div>
        <div class="panel-body"><img src="img/flipkart_logo.png" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Coupons are valid for a limited time only. Flipkart reserves the right to modify or cancel coupons at any time</div>
      </div>
    </div>
    <div class="col-sm-2" data-toggle="tooltip" title="click here for offer!"> 
      <div class="panel panel-primary" onclick="loadmodalitem3()">
        <div class="panel-heading">Flat 5% pay back on Myntra coupon</div>
        <div class="panel-body"><img src="img/myntra-logo.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Coupons are valid for a limited time only. Myntra reserves the right to modify or cancel coupons at any time</div>
      </div>
    </div>
    <div class="col-sm-2" data-toggle="tooltip" title="click here for offer!">
      <div class="panel panel-primary" onclick="loadmodalitem4()">
        <div class="panel-heading">Flat 15% pay back on Ebay coupon</div>
        <div class="panel-body"><img src="img/ebay_logo.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Coupons are valid for a limited time only. Ebay reserves the right to modify or cancel coupons at any time</div>
      </div>
    </div>
    <div class="col-sm-2" data-toggle="tooltip" title="click here for offer!"> 
      <div class="panel panel-primary" onclick="loadmodalitem5()">
        <div class="panel-heading">Flat 25% pay back on Alibaba coupon</div>
        <div class="panel-body"><img src="img/ali_logo.png" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Coupons are valid for a limited time only. Alibaba reserves the right to modify or cancel coupons at any time</div>
      </div>
    </div>
    <div class="col-sm-2" data-toggle="tooltip" title="click here for offer!"> 
      <div class="panel panel-primary" onclick="loadmodalitem6()">
        <div class="panel-heading">Flat 8% pay back on Paytm coupon</div>
        <div class="panel-body"><img src="img/paytm_logo.jpg" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Coupons are valid for a limited time only. Paytm reserves the right to modify or cancel coupons at any time</div>
      </div>
    </div>
  </div><br>
												<div class="modal fade" id="myModalitem1" tabindex="-1" role="dialog" >
    												<div class="modal-dialog">
      													<div class="modal-content">
        													<div class="modal-header" style="padding:35px 50px;">
          														<button type="button" class="close" data-dismiss="modal">&times;</button>
          														<h4 style="color:green"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase Amazon gift voucher and get cash back of 10%</h4>
          																	<div class="row">
           										 								<p>choose the coupon</p>
           										 								<a onclick="modalrecharge1()">do you want to Recharge your Wallet ?</a>
           										 							</div>
        													</div>
        													<div class="modal-body" style="padding:40px 50px;">
         											 			<form role="form" name="myform1" name="purchase" action ="PurchaseCoupon" method="post">
         											 						<input type="hidden" name="companyname" value="Amazon"/>
              																<div class="row" align="center">
              																	<input type="checkbox" name="amzoncoupon" id="ckb1" value="500"/>
																				<img src="" alt="sample image 1" height="100" width="400">
																			</div><br>
																			<div class="row" align="center">
              																	<input type="checkbox" name="amzoncoupon" id="ckb1" value="1000"/>
																				<img src="" alt="sample image 2" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="amzoncoupon" id="ckb2" value="2000"/>
																				<img src="" alt="sample image 3" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="amzoncoupon" id="ckb3" value="5000"/>
																				<img src="" alt="sample image 4" height="100" width="400">
																			</div><br>
																			<div class="row">
																				<P align="center"><button type="submit" class="btn btn-success btn-lg" id="myBtnpurchase"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase </button></P>
            																</div>
          											 			</form>
        													</div>
       														<div class="modal-footer">
          														<button type="submit" class="btn btn-danger btn-sm btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         								 					</div>
      													</div>
   													</div>
  												</div>
  												
  												<div class="modal fade" id="myModalitem2" tabindex="-1" role="dialog">
    												<div class="modal-dialog">
      													<div class="modal-content">
        													<div class="modal-header" style="padding:35px 50px;">
          														<button type="button" class="close" data-dismiss="modal">&times;</button>
          														<h4 style="color:green"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase Flipkart gift voucher and get cash back of 15%</h4>
          																	<div class="row">
           										 								<p>choose the coupon</p>
           										 								<a onclick="modalrecharge2()">do you want to Recharge your Wallet?</a>
           										 							</div>
        													</div>
        													<div class="modal-body" style="padding:40px 50px;">
         											 			<form role="form" name="purchase" action ="PurchaseCoupon" method="post">
         											 						<input type="hidden" name="companyname" value="Flipkart"/>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Flipkartcoupon" id="ckb1" value="500"/>
																				<img src="" alt="sample image 1" height="100" width="400">
																			</div><br>
																			<div class="row" align="center">
              																	<input type="checkbox" name="Flipkartcoupon" id="ckb2" value="1000"/>
																				<img src="" alt="sample image 2" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Flipkartcoupon" id="ckb2" value="2000"/>
																				<img src="" alt="sample image 3" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Flipkartcoupon" id="ckb3" value="5000"/>
																				<img src="" alt="sample image 4" height="100" width="400">
																			</div><br>
																			<div class="row">
																				<P align="center"><button type="submit" class="btn btn-success btn-lg" id="myBtnpurchase"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase </button></P>
            																</div>
          											 			</form>
        													</div>
       														<div class="modal-footer">
          														<button type="submit" class="btn btn-danger btn-sm btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         								 					</div>
      													</div>
   													</div>
  												</div>
  												
  												<div class="modal fade" id="myModalitem3" tabindex="-1" role="dialog">
    												<div class="modal-dialog">
      													<div class="modal-content">
        													<div class="modal-header" style="padding:35px 50px;">
          														<button type="button" class="close" data-dismiss="modal">&times;</button>
          														<h4 style="color:green"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase Myntra gift voucher and get cash back of 5%</h4>
          																	<div class="row">
           										 								<p>choose the coupon</p>
           										 								<a onclick="modalrecharge3()">do you want to Recharge your Wallet?</a>
           										 							</div>
        													</div>
        													<div class="modal-body" style="padding:40px 50px;">
         											 			<form role="form" name="purchase" action ="PurchaseCoupon" method="post">
         											 						<input type="hidden" name="companyname" value="Myntra"/>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Myntracoupon" id="ckb1" value="500"/>
																				<img src="" alt="sample image 1" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Myntracoupon" id="ckb2" value="1000"/>
																				<img src="" alt="sample image 2" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Myntracoupon" id="ckb3" value="2000"/>
																				<img src="" alt="sample image 3" height="100" width="400">
																			</div><br>
																			<div class="row" align="center">
              																	<input type="checkbox" name="Myntracoupon" id="ckb3" value="5000"/>
																				<img src="" alt="sample image 4" height="100" width="400">
																			</div><br>
																			<div class="row">
																				<P align="center"><button type="submit" class="btn btn-success btn-lg" id="myBtnpurchase"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase </button></P>
            																</div>
          											 			</form>
        													</div>
       														<div class="modal-footer">
          														<button type="submit" class="btn btn-danger btn-sm btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         								 					</div>
      													</div>
   													</div>
  												</div>
  												
  												<div class="modal fade" id="myModalitem4" tabindex="-1" role="dialog">
    												<div class="modal-dialog">
      													<div class="modal-content">
        													<div class="modal-header" style="padding:35px 50px;">
          														<button type="button" class="close" data-dismiss="modal">&times;</button>
          														<h4 style="color:green"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase Ebay gift voucher and get cash back of 15%</h4>
          																	<div class="row">
           										 								<p>choose the coupon</p>
           										 								<a onclick="modalrecharge4()">do you want to Recharge your Wallet?</a>
           										 							</div>
        													</div>
        													<div class="modal-body" style="padding:40px 50px;">
         											 			<form role="form" name="purchase" action ="PurchaseCoupon" method="post">
         											 						<input type="hidden" name="companyname" value="Ebay"/>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Ebaycoupon" id="ckb1" value="500"/>
																				<img src="" alt="sample image 1" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Ebaycoupon" id="ckb2" value="1000"/>
																				<img src="" alt="sample image 2" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Ebaycoupon" id="ckb3" value="2000"/>
																				<img src="" alt="sample image 3" height="100" width="400">
																			</div><br>
																			<div class="row" align="center">
              																	<input type="checkbox" name="Ebaycoupon" id="ckb3" value="5000"/>
																				<img src="" alt="sample image 4" height="100" width="400">
																			</div><br>
																			<div class="row">
																				<P align="center"><button type="submit" class="btn btn-success btn-lg" id="myBtnpurchase"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase </button></P>
            																</div>
          											 			</form>
        													</div>
       														<div class="modal-footer">
          														<button type="submit" class="btn btn-danger btn-sm btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         								 					</div>
      													</div>
   													</div>
  												</div>
  												
  												<div class="modal fade" id="myModalitem5" tabindex="-1" role="dialog">
    												<div class="modal-dialog">
      													<div class="modal-content">
        													<div class="modal-header" style="padding:35px 50px;">
          														<button type="button" class="close" data-dismiss="modal">&times;</button>
          														<h4 style="color:green"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase Alibaba gift voucher and get cash back of 25%</h4>
          																	<div class="row">
           										 								<p>choose the coupon</p>
           										 								<a onclick="modalrecharge5()">do you want to Recharge your Wallet?</a>
           										 							</div>
        													</div>
        													<div class="modal-body" style="padding:40px 50px;">
         											 			<form role="form" name="purchase" action ="PurchaseCoupon" method="post">
         											 						<input type="hidden" name="companyname" value="Alibaba"/>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Alibabacoupon" id="ckb1" value="500"/>
																				<img src="" alt="sample image 1" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Alibabacoupon" id="ckb2" value="1000"/>
																				<img src="" alt="sample image 2" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Alibabacoupon" id="ckb3" value="2000"/>
																				<img src="" alt="sample image 3" height="100" width="400">
																			</div><br>
																			<div class="row" align="center">
              																	<input type="checkbox" name="Alibabacoupon" id="ckb3" value="5000"/>
																				<img src="" alt="sample image 4" height="100" width="400">
																			</div><br>
																			<div class="row">
																				<P align="center"><button type="submit" class="btn btn-success btn-lg" id="myBtnpurchase"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase </button></P>
            																</div>
          											 			</form>
        													</div>
       														<div class="modal-footer">
          														<button type="submit" class="btn btn-danger btn-sm btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         								 					</div>
      													</div>
   													</div>
  												</div>
  												
  												<div class="modal fade" id="myModalitem6" tabindex="-1" role="dialog">
    												<div class="modal-dialog">
      													<div class="modal-content">
        													<div class="modal-header" style="padding:35px 50px;">
          														<button type="button" class="close" data-dismiss="modal">&times;</button>
          														<h4 style="color:green"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase Paytm gift voucher and get cash back of 8%</h4>
          																	<div class="row">
           										 								<p>choose the coupon</p>
           										 								<a onclick="modalrecharge6()">do you want to Recharge your Wallet?</a>
           										 							</div>
        													</div>
        													<div class="modal-body" style="padding:40px 50px;">
         											 			<form role="form" name="purchase" action ="PurchaseCoupon" method="post">
         											 						<input type="hidden" name="companyname" value="Paytm"/>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Paytmcoupon" id="ckb1" value="500"/>
																				<img src="" alt="sample image 1" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Paytmcoupon" id="ckb2" value="1000"/>
																				<img src="" alt="sample image 2" height="100" width="400">
																			</div><br>
              																<div class="row" align="center">
              																	<input type="checkbox" name="Paytmcoupon" id="ckb3" value="2000"/>
																				<img src="" alt="sample image 3" height="100" width="400">
																			</div><br>
																			<div class="row" align="center">
              																	<input type="checkbox" name="Paytmcoupon" id="ckb3" value="5000"/>
																				<img src="" alt="sample image 4" height="100" width="400">
																			</div><br>
																			<div class="row">
																				<P align="center"><button type="submit" class="btn btn-success btn-lg" id="myBtnpurchase"><span class="glyphicon glyphicon-shopping-cart"></span> Purchase </button></P>
            																</div>
          											 			</form>
        													</div>
       														<div class="modal-footer">
          														<button type="submit" class="btn btn-danger btn-sm btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         								 					</div>
      													</div>
   													</div>
  												</div>
  												
  												<div class="modal fade" id="myModalrecharge" tabindex="-1" role="dialog">
    												<div class="modal-dialog">
      													<div class="modal-content">
        													<div class="modal-header" style="padding:35px 50px;">
          														<button type="button" class="close" data-dismiss="modal">&times;</button>
          														<h4 style="color:green; align:center;"><span class="glyphicon glyphicon-piggy-bank"></span> Recharge your wallet</h4>
        													</div>
        													<div class="modal-body" style="padding:40px 50px;">
         											 									<form role="form" action ="RechargeAccount" method="post">
           										 											<div class="form-group">
              																					<label for="usrname"><span class="glyphicon glyphicon-user"></span> UserName </label>
              																					<input type="text" name="form-email" required title="abc@xyz.com" placeholder="Enter email : abcd@xyz.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" class="form-control" id="usrname" />
            																				</div>
              																					<P align="center"><button type="submit" class="btn btn-success btn-lg" id="myBtnregister14"><span class="glyphicon glyphicon-fingerprint-ok"></span> Generate Recharge Code </button></P>
          											 									</form>
        													</div>
       														<div class="modal-footer">
          														<button type="submit" class="btn btn-danger btn-sm btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         								 					</div>
      													</div>
   													</div>
  												</div>
  												
  												
  												<!-- Modal -->
			<div class="modal fade" id="myverifycode" tabindex="-1" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header" style="padding:30px 50px;">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4><span class="glyphicon glyphicon-eye-close"></span> Recharge Code Verification </h4>
							</div>
							<div class="modal-body" style="padding:40px 50px;">
								<form role="form" method="post" action="RechargeValidation">
									<div class="form-group">
										<label for="verification"><span class="glyphicon glyphicon-user"></span> Enter Recharge Code </label>
										<input type="password" name="rechargeOTP" required class="form-control"  placeholder="Password"/><br/>
									</div>
									<button type="submit" class="btn btn-success btn-lg" id="myBtnregister1"><span class="glyphicon glyphicon-off"></span> Verify </button>
								</form>
							</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-danger btn-sm btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
						</div>
					</div>
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
  
  
  
			
 
  