package giftcard.registrationcontrollers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import giftcard.logincontrollers.SendMail;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RegisterController() {
		super();
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("form-first-name");
		String lastName = request.getParameter("form-last-name");
		String emailID = request.getParameter("form-email");
		String passWord = request.getParameter("form-password");
		String userCountry = request.getParameter("form-country");
		String userState = request.getParameter("form-state");
		String userCity = request.getParameter("form-city");
		String dateofbirth = request.getParameter("form-dob");
		String mobileNumber = request.getParameter("form-mobilenumber");
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			Connection myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/websit_giftcard","root","manojmore");
			PreparedStatement checkAvailability = myconnection.prepareStatement("select * from `websit_giftcard`.`user_registration` where email=? and mobile_number=?");  
			checkAvailability.setString(1,emailID);  
			checkAvailability.setString(2,mobileNumber);
            ResultSet rs = checkAvailability.executeQuery();
            PrintWriter out = response.getWriter();
            if (!rs.next()) {
            	PreparedStatement prestateInsert =(PreparedStatement) myconnection.prepareStatement("INSERT INTO `websit_giftcard`.`user_registration`(`first_name`,`last_name`,`email`,`password`,`city`,`state`,`country`,`DOB`,`mobile_number`,`registration_date`) values(?,?,?,?,?,?,?,?,?,now())");
            	prestateInsert.setString(1,firstName);  
            	prestateInsert.setString(2,lastName);        
            	prestateInsert.setString(3,emailID);
            	prestateInsert.setString(4,passWord);
            	prestateInsert.setString(5,userCity);
            	prestateInsert.setString(6,userState);
            	prestateInsert.setString(7,userCountry);
            	prestateInsert.setString(8,dateofbirth);
            	prestateInsert.setString(9,mobileNumber);
            	int i = prestateInsert.executeUpdate();
            	int j=0;
            	if(i!=0){  
            		PreparedStatement prestateInsert2 =(PreparedStatement) myconnection.prepareStatement("select * from `websit_giftcard`.`user_registration` where email = ?");
            		prestateInsert2.setString(1,emailID);
            		ResultSet rs1 = prestateInsert2.executeQuery();
            			if(rs1.next()){
            			String id =rs1.getString("user_id");
            			int initialCash =1000;
            			PreparedStatement prestateInsert3 =(PreparedStatement) myconnection.prepareStatement("INSERT INTO `websit_giftcard`.`user_amount_transcation`(`user_id`,`available_amount`) values(?,?)");
                		prestateInsert3.setString(1,id);
                		prestateInsert3.setLong(2,initialCash);
                		j = prestateInsert3.executeUpdate();
            			}
            		}else{
            			response.setContentType("text/html;charset=UTF-8");
    	      		  	request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);
    	      		  	out.println("<script type=\"text/javascript\">");  
    	      		  	out.println("alert('Failed to update initial amount,Connection error');");  
    	      		  	out.println("</script>");
            		}
            	if(j!=0){
            		SendMail mail=new SendMail();
		            mail.fnsendmail(emailID,"Welcome to EGift card center");
		            out.println("success");
		            response.setContentType("text/html;charset=UTF-8");
	      		  	request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);
	      		  	out.println("<script type=\"text/javascript\">");  
	      		  	out.println("alert('Registered successfully,login to continue');");  
	      		  	out.println("</script>");
            		}else{  
            		response.setContentType("text/html;charset=UTF-8");
	      		  	request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);
	      		  	out.println("<script type=\"text/javascript\">");  
	      		  	out.println("alert('Registration Failed, try once again');");  
	      		  	out.println("</script>");
            		}
            	prestateInsert.close();
            }else{
            	response.setContentType("text/html;charset=UTF-8");
      		  	request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);
      		  	out.println("<script type=\"text/javascript\">");  
      		  	out.println("alert('User already exists,login with your User Name and Password');");  
      		  	out.println("</script>");  
            }
            checkAvailability.close();
		}
		catch(Exception ex){ex.printStackTrace();}
	}
}