package giftcard.forgotusernamecontrollers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ForgotPasswordAuthentication")
public class ForgotPasswordAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ForgotPasswordAuthentication() {
        super();
    }
    private int counter;
    public void init(){counter=0;}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
        String enteredOTP = request.getParameter("otp");
        HttpSession session = request.getSession();
        String calculatedOTP = (String) session.getAttribute("myId");
       // String email = (String) session.getAttribute("email");
        try{
        	if(enteredOTP.equals(calculatedOTP))
        		response.sendRedirect("Reset.html");  
        	else{
        		if(counter<=1){
        			counter=counter+1;
              	  	request.getRequestDispatcher("UserAuthenticate.html").include(request, response);
              	  	response.setContentType("text/html");  
              	  	out.println("<script type=\"text/javascript\">");  
              	  	out.println("alert('Invalid Verification code try again');");  
              	  	out.println("</script>");
              	  }
              	  else{
              		request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);
              		response.setContentType("text/html");  
              		out.println("<script type=\"text/javascript\">");  
              		out.println("alert('Session Expried try after some time');");  
              		out.println("</script>");
              		session.invalidate();
              	  }
        	}
          }
        catch(Exception se){
        	se.printStackTrace();
        }
	}
}
