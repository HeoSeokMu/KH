package library.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.bookDAO;

@Controller
public class email {

	@RequestMapping(value="/email.kh", method=RequestMethod.GET)
	public ModelAndView email(HttpServletRequest req) throws Exception{
		String book_id = req.getParameter("book_id");
		
		String host = "smtp.gmail.com";//smtp ����
		String from = "KH_School.com";
		String fromName = "KH_School";
		String to1;										//*���� �̸���
		String subject = "[KH_School] �����ݳ� �ȳ� ";			//*����
		
		
		bookDAO dbPro = bookDAO.getInstance();
		List<String> list = dbPro.getEmailList(book_id);
		String book_name = dbPro.getBook_name(Integer.parseInt(book_id));
		
		String body= book_name + " ������ �ݳ��Ǿ����ϴ�.";		//*����
		if(list!=null){
			for(String email : list){
				to1 = email;
				try{
				    // ������Ƽ �� �ν��Ͻ� ������ �⺻����(SMTP ���� ȣ��Ʈ ����)
				Properties props = new Properties();
		
				// G-Mail SMTP ����
				props.put("mail.smtp.starttls.enable","true");
				props.put("mail.transport.protocol", "smtp");
				props.put("mail.smtp.host", host);
				props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.port", "465");
				props.put("mail.smtp.auth", "true");
		
				Session mailSession = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("khjavatest", "ahfmrpT3");
						}
					  });
		
				Message msg = new MimeMessage(mailSession);
				msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B")));//������ ��� ����
				InternetAddress[] address1 = {new InternetAddress(to1)};
				msg.setRecipients(Message.RecipientType.TO, address1);//�޴� �������1
				msg.setSubject(subject);// ���� ����
				msg.setSentDate(new java.util.Date());// ������ ��¥ ����
				msg.setContent(body,"text/html;charset=euc-kr"); // ���� ���� (HTML ����)
		
				Transport.send(msg); // ���� ������
				} catch ( MessagingException ex ) {
				    System.out.print("���� �߼ۿ� ���� �Ͽ����ϴ�.");
				    ex.printStackTrace();
				} catch ( Exception e ){
					System.out.print("���� �߼ۿ� ���� �Ͽ����ϴ�.");
					e.printStackTrace();
				}
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bookList.kh");
		return mv;
	}
}
