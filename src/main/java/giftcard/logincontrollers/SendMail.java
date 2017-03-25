package giftcard.logincontrollers;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail {
	@SuppressWarnings("static-access")
	public void fnsendmail(String email,String code)throws MessagingException{
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("krvikas1011cerner@gmail.com","vikas1234");
		}
		});  
		session.setDebug(true);
		Transport transport = session.getTransport();
		InternetAddress addressFrom = new InternetAddress("krvikas1011cerner@gmail.com");
		MimeMessage message = new MimeMessage(session);
		message.setSender(addressFrom);
		message.setSubject("E-gift card Portal");
		message.setContent(code, "text/plain");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		transport.connect();
		transport.send(message);
		transport.close();
	}

}
