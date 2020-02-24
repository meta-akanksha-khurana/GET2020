package com.metacube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.mailSender.MailSender;

/**
 * MailController is the controller class used for dependency injection in this application
 * @author Akanksha
 *
 */
@RestController
public class MailController {

	private MailSender mailSender;


	// Constructor Injection
	 @Autowired
	  public MailController(MailSender mail)
	  {
	  		this.mailSender=mail; System.out.println("constructor injection done");
	  }
	 


	// Setter Injection
	//@Autowired
	//@Qualifier("mockMail")
	//@Qualifier("smtpMailSender")
	public void setMailSender(MailSender mail)
	{

		this.mailSender=mail;
		System.out.println("setter injection done");
	}



	@GetMapping("/send")
	public String sendMail()
	{
		mailSender.send();
		return "Mail sent successfully!";
	}
}
