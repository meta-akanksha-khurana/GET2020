package com.metacube.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.mailSender.MailSender;
import com.metacube.mailSender.MockMailSender;
import com.metacube.mailSender.SmtpMailSender;

/**
 * This is the configuration class used to create beans
 * @author Akanksha
 *
 */
@Configuration
public class AppConfig {

	
	 // @Bean 
	  //@Primary
	  public MailSender smtpMailSender() 
	  {
		  return new SmtpMailSender(); 
	  }
	 
	
	
	//@Bean
	//@Primary
	public MailSender mockMailSender()
	{
		return new MockMailSender();
	}
}
