package thread;

import java.util.ArrayList;
import java.util.Calendar;
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

import dao.bookDAO;
import dto.emailDTO;
import dto.libraryDTO;

public class bookCheckThread extends Thread{

	 public void run() {       // 스레드 클래스의 run 메소드를 오버라이딩한다.
	        while(true) {
	            System.out.println("bookCheckThread");
	            try {
	                Thread.sleep(1000*60*60*12);	//12시간
	                List<emailDTO> list = new ArrayList<emailDTO>();
	                
	                Calendar date = Calendar.getInstance();
	        		java.util.Date uDate = date.getTime();		//calender -> util.date 형변환
	        		java.sql.Date sDate = new java.sql.Date(uDate.getTime());	//util.date -> sql.date 변환
	        		java.sql.Timestamp tDate = new java.sql.Timestamp(uDate.getTime());	//util.date -> Timestamp 변환
	        		
	                bookDAO dbPro = bookDAO.getInstance();
	                list = dbPro.getTurnin(tDate);
	                
	                String host = "smtp.gmail.com";//smtp 서버
	        		String from = "KH_School.com";
	        		String fromName = "KH_School";
	        		String to1;										//*보낼 이메일
	        		String subject = "[KH_School] 도서연체 안내 ";			//*제목
	        		String body;
	                
	        		if(list!=null){
	        			for(emailDTO a : list){
	        				to1 = a.getEmail();
	        				body = a.getBook_title() + " 도서가 연체되었습니다. 반납해주세요";		//*내용
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
	                
	            } catch (Exception e) {

	            }          
	        }
	 }
}
