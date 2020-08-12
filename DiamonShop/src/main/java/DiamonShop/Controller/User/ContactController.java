package DiamonShop.Controller.User;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactController extends UserController {
	 
	  public static void main(String args[]) throws AddressException, MessagingException {
	    sendText();
	  }
	 
	  public static void sendText() throws AddressException, MessagingException {
	    Properties mailServerProperties;
	    Session getMailSession;
	    MimeMessage mailMessage;
	 
	    // Step1: setup Mail Server
	    mailServerProperties = System.getProperties();
	    mailServerProperties.put("mail.smtp.port", "587");
	    mailServerProperties.put("mail.smtp.auth", "true");
	    mailServerProperties.put("mail.smtp.starttls.enable", "true");
	 
	    // Step2: get Mail Session
	    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	    mailMessage = new MimeMessage(getMailSession);
	 
	    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("LoginInfo.username")); //Thay abc bằng địa chỉ người nhận
	 
	    // Bạn có thể chọn CC, BCC
//	    generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail
	 
	 
	    mailMessage.setSubject("Chào mừng bạn đến với DiamonShop");
	    mailMessage.setText("Liên hệ 0969101998 để nạp tiền vào tài khoản và sử dụng dịch vụ của chúng tôi. Xin cảm ơn!");
	 
	    // Step3: Send mail
	    Transport transport = getMailSession.getTransport("smtp");
	 
	    // Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail của bạn
	    transport.connect("smtp.gmail.com", "tus81098@gmail.com", "tung0969101998"); 
	    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
	    transport.close();
	  }
}
	 
