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

	 public void run() {       // ������ Ŭ������ run �޼ҵ带 �������̵��Ѵ�.
	        while(true) {
	            System.out.println("bookCheckThread");
	            try {
	                Thread.sleep(1000*60*60*12);	//12�ð�
	                List<emailDTO> list = new ArrayList<emailDTO>();
	                
	                Calendar date = Calendar.getInstance();
	        		java.util.Date uDate = date.getTime();		//calender -> util.date ����ȯ
	        		java.sql.Date sDate = new java.sql.Date(uDate.getTime());	//util.date -> sql.date ��ȯ
	        		java.sql.Timestamp tDate = new java.sql.Timestamp(uDate.getTime());	//util.date -> Timestamp ��ȯ
	        		
	                bookDAO dbPro = bookDAO.getInstance();
	                list = dbPro.getTurnin(tDate);
	                
	                String host = "smtp.gmail.com";//smtp ����
	        		String from = "KH_School.com";
	        		String fromName = "KH_School";
	        		String to1;										//*���� �̸���
	        		String subject = "[KH_School] ������ü �ȳ� ";			//*����
	        		String body;
	                
	        		if(list!=null){
	        			for(emailDTO a : list){
	        				to1 = a.getEmail();
	        				body = a.getBook_title() + " ������ ��ü�Ǿ����ϴ�. �ݳ����ּ���";		//*����
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
	                
	            } catch (Exception e) {

	            }          
	        }
	 }
}
