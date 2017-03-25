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

@WebServlet("/ForgotUsernameController")
public class ForgotUsernameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ForgotUsernameController() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        IDGenerator id=new IDGenerator();
        String email = request.getParameter("form-email");
        boolean userExists =false;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           PrintWriter out = response.getWriter();
           Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/websit_giftcard","root","manojmore");
           PreparedStatement checkUser =connect.prepareStatement("select * from `websit_giftcard`.`user_registration` where email=?"); 
           checkUser.setString(1, email);
           ResultSet rs =checkUser.executeQuery();
           userExists = rs.next();
           if(userExists){
        	   String randomCode=id.generateRandomString();
        	   SendMail mail=new SendMail();
        	   mail.fnsendmail(email,randomCode);
        	   HttpSession session = request.getSession();
        	   session.setAttribute("myId",randomCode);
        	   session.setAttribute("email",email);
        	   request.getRequestDispatcher("UserAuthenticate.html").include(request, response);;
        	   response.setContentType("text/html");  
        	   out.println("<script type=\"text/javascript\">");  
        	   out.println("alert('Enter valid Verification code, you will have only 3 attempts.');");  
        	   out.println("</script>");
           }else{
        	   request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);;
        	   response.setContentType("text/html");  
        	   out.println("<script type=\"text/javascript\">");  
        	   out.println("alert('User doesn't Exists, Please Register.');");  
        	   out.println("</script>");
           }
        }
        catch(Exception se){
        	se.printStackTrace();
        }
	}
}
