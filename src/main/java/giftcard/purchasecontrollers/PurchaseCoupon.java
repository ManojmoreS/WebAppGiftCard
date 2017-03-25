package giftcard.purchasecontrollers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import giftcard.forgotusernamecontrollers.IDGenerator;
import giftcard.logincontrollers.SendMail;
@WebServlet("/PurchaseCoupon")
public class PurchaseCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PurchaseCoupon(){super();}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*initializing company name*/
		String companyName = request.getParameter("companyname");
		String couponName=null;
		double disCount=0.0;
		int counterCoupon500=0,counterCoupon1000=0,counterCoupon2000=0,counterCoupon5000=0,index=0,availableAmount=0,totalCouponValue=0,tempCoupon500=0,tempCoupon1000=0,tempCoupon2000=0,tempCoupon5000=0;
		String couponName1="",couponName2="",couponName3="",couponName4="";
		String couponPurchased="";
		/*initializing coupon type*/
		if(companyName.equals("Amazon")){couponName="amzoncoupon";disCount=0.1;}
		if(companyName.equals("Flipkart")){couponName="Flipkartcoupon";disCount=0.15;}
		if(companyName.equals("Myntra")){couponName="Myntracoupon";disCount=0.05;}
		if(companyName.equals("Ebay")){couponName="Ebaycoupon";disCount=0.15;}
		if(companyName.equals("Alibaba")){couponName="Alibabacoupon";disCount=0.25;}
		if(companyName.equals("Paytm")){couponName="Paytmcoupon";disCount=0.08;}
		/*get coupon value in String*/
		String[] couponValueStr = request.getParameterValues(couponName);
		Integer[] couponValueInt=new Integer[couponValueStr.length];
		IDGenerator id=new IDGenerator();
		PrintWriter out = response.getWriter();
		/*Converting String to Interger*/
		for(String str:couponValueStr){
				try{
					couponValueInt[index]=Integer.parseInt(str.trim());
					index++;
					}catch(NumberFormatException e) {
						e.printStackTrace();
					}
	    	}
		for(Integer intval:couponValueInt){
			if(intval == 500){counterCoupon500++;couponName1="Coupon 500/-";}
			if(intval == 1000){counterCoupon1000++;couponName2=" Coupon 1000/-";}
			if(intval == 2000){counterCoupon2000++;couponName3=" Coupon 2000/-";}
			if(intval == 5000){counterCoupon5000++;couponName4=" Coupon 5000/-";}
			totalCouponValue = intval+totalCouponValue;
			couponPurchased = " "+couponName1+couponName2+couponName3+couponName4+" ";
		}
		/*Obtain the session object*/
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("name");
		try{/*setup Data base Connection*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/websit_giftcard","root","manojmore");
			/*Check user exists*/
			PreparedStatement checkAmount = myconnection.prepareStatement("select * from `websit_giftcard`.`user_amount_transcation` where (user_id=(select user_id from `websit_giftcard`.`user_registration` where email=?))");  
			checkAmount.setString(1,userName);
			ResultSet rs = checkAmount.executeQuery();
			if(rs.next()){
				/*Check Available balance before purchase*/
				availableAmount =rs.getInt("available_amount");
					if(availableAmount<totalCouponValue){
						response.setContentType("text/html;charset=UTF-8");
						request.getRequestDispatcher("LoggedIn.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Insufficient funds to purchase,Please recharge your Wallet. ');");
						out.println("loadmodalrecharge();"); 
						out.println("</script>");
					}else{
						/*if user has sufficient balance then call calculatePayBack()* and then update the user account with proper remaining balance+Pay back*/
						TransactionProcess objTransactionProcess = new TransactionProcess(); 
						int currentBalance = objTransactionProcess.calculatePayBack(totalCouponValue,availableAmount,disCount);
						PreparedStatement updateAmount = myconnection.prepareStatement("UPDATE `websit_giftcard`.`user_amount_transcation` SET available_amount=? WHERE user_id=?");  
						updateAmount.setInt(1,currentBalance);
						updateAmount.setInt(2,rs.getInt("user_id"));
						int i=updateAmount.executeUpdate();
						if(i!=0){
							response.setContentType("text/html;charset=UTF-8");
							request.getRequestDispatcher("LoggedIn.jsp").include(request, response);
							out.println("<script type=\"text/javascript\">");  
							out.println("alert('successfull Transaction,Check your mail for Coupon code and check your balance');");
							out.println("loadmodalbalance();"); 
							out.println("</script>");
							
							String couponCode=id.generateRandomString();
							SendMail mail=new SendMail();
							mail.fnsendmail(userName,"Use the Coupon Code '"+couponCode+"'for your purchase, Use within 24 hrs");
							PreparedStatement checkCoupon = myconnection.prepareStatement("select * from `websit_giftcard`.`website_coupon_count` where website_name=?");  
							checkCoupon.setString(1,companyName);
							ResultSet rs1 = checkCoupon.executeQuery();
								if(rs1.next()){
									/*calculating number Coupon being sold and updating same in db*/
									tempCoupon500 = rs1.getInt("type_one_500");
									tempCoupon1000 = rs1.getInt("type_two_1000");
									tempCoupon2000 = rs1.getInt("type_three_2000");
									tempCoupon5000 = rs1.getInt("type_four_5000");
									tempCoupon500 = tempCoupon500+counterCoupon500;
									tempCoupon1000 = tempCoupon1000+counterCoupon1000;
									tempCoupon2000 = tempCoupon2000+counterCoupon2000;
									tempCoupon5000 = tempCoupon5000+counterCoupon5000;
									PreparedStatement updateCoupon= myconnection.prepareStatement("UPDATE `websit_giftcard`.`website_coupon_count` SET type_one_500=?,type_two_1000=?,type_three_2000=?,type_four_5000=?,total_coupon=? WHERE website_name=?");  
									updateCoupon.setInt(1,tempCoupon500);
									updateCoupon.setInt(2,tempCoupon1000);
									updateCoupon.setInt(3,tempCoupon2000);
									updateCoupon.setInt(4,tempCoupon5000);
									int tempTotal=tempCoupon500+tempCoupon1000+tempCoupon2000+tempCoupon5000;
									updateCoupon.setInt(5,tempTotal);
									updateCoupon.setString(6,companyName);
									updateCoupon.executeUpdate();
								}else{
									/*If new company name then make fresh entry into table*/
									PreparedStatement prestateInsert =(PreparedStatement) myconnection.prepareStatement("INSERT INTO `websit_giftcard`.`website_coupon_count`(`website_name`,`type_one_500`,`type_two_1000`,`type_three_2000`,`type_four_5000`,`total_coupon`) values(?,?,?,?,?,?)");
									prestateInsert.setString(1,companyName);
									prestateInsert.setInt(2,counterCoupon500);
									prestateInsert.setInt(3,counterCoupon1000);
									prestateInsert.setInt(4,counterCoupon2000);
									prestateInsert.setInt(5,counterCoupon5000);
									int couponTotal =counterCoupon500+counterCoupon1000+counterCoupon2000+counterCoupon5000;
									prestateInsert.setInt(6,couponTotal);
									prestateInsert.executeUpdate();
								}
								PreparedStatement insertPurchaseLog =(PreparedStatement) myconnection.prepareStatement("INSERT INTO `websit_giftcard`.`purchase_log`(`transaction_id`,`website_name`,`coupon_purchased`,`purchase_date`) values(?,?,?,now())");
								insertPurchaseLog.setLong(1,rs.getInt("iduser_amount_transcation"));
								insertPurchaseLog.setString(2,companyName);
								insertPurchaseLog.setString(3,couponPurchased);
								insertPurchaseLog.executeUpdate();
						}else{
							response.setContentType("text/html;charset=UTF-8");
							request.getRequestDispatcher("LoggedIn.jsp").include(request, response);
							out.println("<script type=\"text/javascript\">");  
							out.println("alert('Transaction failed,try again');");  
							out.println("</script>");
						}
					}
				}
			}
			catch(Exception ex){ex.printStackTrace();}	 	
	}
}
