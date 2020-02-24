package com.metacube.mailSender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/**
 * This is the SmtpMailSender class implementing MailSender interface
 * @author Akanksha
 *
 */
//@Primary
@Component
//@Component("smtpMail")
public class SmtpMailSender implements MailSender {

	@Override
	public void send() {
		System.out.println("send SMTP mail");
	}

}
