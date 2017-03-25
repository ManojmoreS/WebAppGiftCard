package giftcard.logincontrollers;
import java.sql.*;
public class ValidateUser {
	 public static boolean checkUser(String email,String pass){ 
		 boolean userExists =false;
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/websit_giftcard","root","manojmore");
			 PreparedStatement ps =con.prepareStatement("select * from user_registration where email=? and password=?");
			 ps.setString(1, email);
			 ps.setString(2, pass);
			 ResultSet rs =ps.executeQuery();
			 userExists = rs.next();
		 	}
		 catch(Exception e){
			 e.printStackTrace();
		 	}
         return userExists;                 
     } 	
}