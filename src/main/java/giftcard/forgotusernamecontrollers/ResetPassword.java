package giftcard.forgotusernamecontrollers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giftcard.logincontrollers.SendMail;

@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResetPassword() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        String pass = request.getParameter("newPass");
		        HttpSession session = request.getSession();
		        String email = (String) session.getAttribute("email");
		        try{
		        	Class.forName("com.mysql.jdbc.Driver");
		        	Connection  con= DriverManager.getConnection("jdbc:mysql://localhost:3306/websit_giftcard","root","manojmore");
		        	PreparedStatement ps=con.prepareStatement("UPDATE `websit_giftcard`.`user_registration` SET password = ? WHERE email = ?");
		        	ps.setString(1, pass);
		        	ps.setString(2, email);
		        	int queryCount=ps.executeUpdate();
		        	if(queryCount>0){
		        		SendMail mail=new SendMail();
		        		mail.fnsendmail(email,"Password Changed Successfully");
		        		request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);
		  		  		response.setContentType("text/html");  
		  		  		out.println("<script type=\"text/javascript\">");  
		  		  		out.println("alert('Password has been changed login with your new password');");  
		  		  		out.println("</script>");
		        	}else{
		        		request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);
		  		  		response.setContentType("text/html");  
		  		  		out.println("<script type=\"text/javascript\">");  
		  		  		out.println("alert('Error Occured during password change,Please Try again.');");  
		  		  		out.println("</script>");
		        	}
		        }
		        catch(Exception se){se.printStackTrace();}
        }
}
