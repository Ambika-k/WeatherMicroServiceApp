package com.spring.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.restapi.models.SmsRequest;
import com.spring.restapi.services.SmsService;

// Twillio controller to send sms

@Controller
public class TwillioController {
	@Autowired
	private SmsService smsService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		return "index";
		
	}
	
	@ResponseBody
	@GetMapping("/sendmessage/{number}")
	//public ResponseEntity<Object> sendMessage(@RequestBody SmsRequest smsRequest) {
	public String sendMessage(@PathVariable("number")String number) {
		//System.out.println(smsRequest.getNumber());
		String status = smsService.sendSms(number);
		//System.out.println(status);
		System.out.println("send sms end twilio\n");
		
		/*
		 * if("sent".equals(status)||"queued".equals(status)) {
		 * System.out.println("sent"); return new
		 * ResponseEntity<Object>("Sms Sent succesfully", HttpStatus.OK); } return new
		 * ResponseEntity<Object>("Failed to send message",HttpStatus.NOT_FOUND);
		 */
		 
		return status;
	}
}
