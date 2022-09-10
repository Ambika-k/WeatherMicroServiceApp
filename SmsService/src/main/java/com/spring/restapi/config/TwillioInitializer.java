package com.spring.restapi.config;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;
@Configuration
public class TwillioInitializer {
	private final TwillioProperties twillioProperties;

	public TwillioInitializer(TwillioProperties twillioProperties) {
		super();
		this.twillioProperties = twillioProperties;
		Twilio.init(twillioProperties.getAccountSid(), twillioProperties.getAuthToken());
		System.out.println("twilio intialized with account: "+twillioProperties.getAccountSid());
	}

}
