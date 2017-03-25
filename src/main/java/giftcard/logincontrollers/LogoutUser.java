package giftcard.logincontrollers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutUser")
public class LogoutUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogoutUser() {super();}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
			response.setHeader("Cache-Control","no-cache");
		    response.setHeader("Cache-Control","no-store");
		    response.setDateHeader("Expires", 0);
		    response.setHeader("Pragma","no-cache");
			response.setContentType("text/html");  
    		PrintWriter out=response.getWriter();
    		HttpSession session=request.getSession(); 
    		session.removeAttribute("name");
            session.invalidate();
            response.sendRedirect("GiftcardHomePage.jsp");
    		out.close();  
	}  
}
