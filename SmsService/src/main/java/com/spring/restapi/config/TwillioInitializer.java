package com.spring.restapi.config;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;
@Configuration
public class TwillioInitializer {
	private final TwillioProperties twillioProperties;
	public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

	public TwillioInitializer(TwillioProperties twillioProperties) {
		
		super();
		System.out.println("twilio intialized with account: "+AUTH_TOKEN);
		System.out.println("twilio intialized with sid: "+ACCOUNT_SID);
		this.twillioProperties = twillioProperties;
		
		//Twilio.init(twillioProperties.getAccountSid(), twillioProperties.getAuthToken());
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		//System.out.println("twilio intialized with account: "+twillioProperties.getAccountSid());
		System.out.println("twilio intialized with account: "+AUTH_TOKEN);
	}

}
