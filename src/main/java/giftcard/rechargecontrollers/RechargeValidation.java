package giftcard.rechargecontrollers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RechargeValidation")
public class RechargeValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RechargeValidation() {
        super();
    }
    int counter =0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
        String enteredOTP = request.getParameter("rechargeOTP");
        HttpSession session = request.getSession();
        String calculatedOTP = (String) session.getAttribute("rechargeId");
        try{
        	if(enteredOTP.equals(calculatedOTP))
        		request.getRequestDispatcher("Recharge.jsp").include(request, response);  
        	else{
        		if(counter<=1){
        			counter=counter+1;
              	  	request.getRequestDispatcher("RechargeValidationPage.jsp").include(request, response);
              	  	response.setContentType("text/html");  
              	  	out.println("<script type=\"text/javascript\">");  
              	  	out.println("alert('Invalid Recharge code try again');");  
              	  	out.println("</script>");
              	  }
              	  else{
              		request.getRequestDispatcher("LoggedIn.jsp").include(request, response);
              		response.setContentType("text/html");  
              		out.println("<script type=\"text/javascript\">");  
              		out.println("alert('Recharge code Session Expried try again after some time');");  
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
