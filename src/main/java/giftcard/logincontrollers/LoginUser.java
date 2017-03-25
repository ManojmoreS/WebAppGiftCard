package giftcard.logincontrollers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginUser() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("form-email");
        String password = request.getParameter("form-logpassword");
        if(ValidateUser.checkUser(email, password)){
        	 HttpSession session=request.getSession(true);  
        	 session.setAttribute("name",email); 
        	 request.getRequestDispatcher("LoggedIn.jsp").include(request, response);
        }else{
        	request.getRequestDispatcher("GiftcardHomePage.jsp").include(request, response);;
        	response.setContentType("text/html");  
  			out.println("<script type=\"text/javascript\">");  
  			out.println("alert('Invalid user name or password, try again');");  
  			out.println("</script>");
        }
        out.close();
	}
}
