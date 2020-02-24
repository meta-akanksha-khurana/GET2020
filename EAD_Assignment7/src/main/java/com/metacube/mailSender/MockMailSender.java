package com.metacube.mailSender;

import org.springframework.stereotype.Component;


/**
 * This is the MockMailSender class implementing MailSender interface
 * @author Akanksha
 *
 */
//@Component
//@Component("mockMail")
public class MockMailSender implements MailSender{

	
	@Override
	public void send() {
		System.out.println("send Mock mail");
	}
}
