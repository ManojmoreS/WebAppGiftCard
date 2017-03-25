package giftcard.rechargecontrollers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import giftcard.logincontrollers.SendMail;

@WebServlet("/RechargeUserAccount")
public class RechargeUserAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RechargeUserAccount() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String strAmount = request.getParameter("rechargeAmount");
        int intAmount = Integer.parseInt(strAmount.trim());
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection  con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/websit_giftcard","root","manojmore");
        	PreparedStatement ps1 = (PreparedStatement) con.prepareStatement("select * from `websit_giftcard`.`user_amount_transcation` where (user_id=(select user_id from `websit_giftcard`.`user_registration` where email=?))");
        	ps1.setString(1, email);
        	ResultSet rs1 = ps1.executeQuery();
        	int currentAmount=0;
			if(rs1.next())
        		currentAmount = rs1.getInt("available_amount");
			intAmount = intAmount + currentAmount;
        	PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE `websit_giftcard`.`user_amount_transcation` SET available_amount = ? where (user_id=(select user_id from `websit_giftcard`.`user_registration` where email=?))");  
    		ps.setLong(1, intAmount);
    		ps.setString(2, email);
        	int queryCount=ps.executeUpdate();
        	if(queryCount>0){
        		SendMail mail=new SendMail();
        		mail.fnsendmail(email,"Recharge Successful");
        		request.getRequestDispatcher("LoggedIn.jsp").include(request,response);
  		  		response.setContentType("text/html");  
  		  		out.println("<script type=\"text/javascript\">");  
  		  		out.println("alert('Recharge Successful');"); 
  		  		out.println("loadmodalbalance();"); 
  		  		out.println("</script>");
        	}
        }
        catch(Exception se){se.printStackTrace();}
        }
}

