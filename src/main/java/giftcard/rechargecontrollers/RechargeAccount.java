package giftcard.rechargecontrollers;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giftcard.forgotusernamecontrollers.IDGenerator;
import giftcard.logincontrollers.SendMail;

@WebServlet("/RechargeAccount")
public class RechargeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RechargeAccount() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession sessionuser=request.getSession();
		String email = (String) sessionuser.getAttribute("name");
        SendMail mail=new SendMail();
        IDGenerator id=new IDGenerator();
        String randomCode=id.generateRandomString();
        try {
        	HttpSession session = request.getSession();
     	    session.setAttribute("rechargeId",randomCode);
     	    session.setAttribute("email",email);
			mail.fnsendmail(email, randomCode);
		} catch (MessagingException e){
			e.printStackTrace();
		}
        request.getRequestDispatcher("RechargeValidationPage.jsp").include(request, response);;
	}

}
