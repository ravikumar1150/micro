package com.nt.maill;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;


@Service
public class CustomerMail {
	
	
	@Autowired
	private JavaMailSender  javaMailSender;
	
	
	@Async
	public void sendMail(String to ,String subject ,String body,String img) throws Exception{
	
		
		MimeMessage  message = javaMailSender.createMimeMessage();
		
		//MimeMessageHelper  helper = new MimeMessageHelper(message,true);
		
		  MimeMessageHelper helper = new MimeMessageHelper(message, true); // true = multipart message
	        helper.setTo(to);
	        helper.setSubject(subject);

	        // Email Body with Inline Image (HTML content)
	        String htmlMsg = "<html><body>"
	                + "<p>" + body + "</p>"
	                + "<img src='cid:image001'/>"  // 'cid:image001' used for inline image
	                + "</body></html>";

	        helper.setText(htmlMsg, true); // true = HTML

	        // Image Attachment as Inline
	        FileSystemResource res = new FileSystemResource(new File(img));
	        helper.addInline("image001", res);

	        // Send mail
	       
	        javaMailSender.send(message);
			
		helper.setFrom("ravikumark1150@gmail.com");

		
		System.out.println("Mail Send Successfull");
		
		
		
		
	}
	
	

}
