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
		
		String host = "smtp.gmail.com";//smtp 서버
		String from = "KH_School.com";
		String fromName = "KH_School";
		String to1;										//*보낼 이메일
		String subject = "[KH_School] 도서반납 안내 ";			//*제목
		
		
		bookDAO dbPro = bookDAO.getInstance();
		List<String> list = dbPro.getEmailList(book_id);
		String book_name = dbPro.getBook_name(Integer.parseInt(book_id));
		
		String body= book_name + " 도서가 반납되었습니다.";		//*내용
		if(list!=null){
			for(String email : list){
				to1 = email;
				try{
				    // 프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
				Properties props = new Properties();
		
				// G-Mail SMTP 사용시
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
				msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B")));//보내는 사람 설정
				InternetAddress[] address1 = {new InternetAddress(to1)};
				msg.setRecipients(Message.RecipientType.TO, address1);//받는 사람설정1
				msg.setSubject(subject);// 제목 설정
				msg.setSentDate(new java.util.Date());// 보내는 날짜 설정
				msg.setContent(body,"text/html;charset=euc-kr"); // 내용 설정 (HTML 형식)
		
				Transport.send(msg); // 메일 보내기
				} catch ( MessagingException ex ) {
				    System.out.print("메일 발송에 실패 하였습니다.");
				    ex.printStackTrace();
				} catch ( Exception e ){
					System.out.print("메일 발송에 실패 하였습니다.");
					e.printStackTrace();
				}
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bookList.kh");
		return mv;
	}
}
