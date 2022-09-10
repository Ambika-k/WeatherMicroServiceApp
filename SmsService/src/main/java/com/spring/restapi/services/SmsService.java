package com.spring.restapi.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.restapi.config.TwillioProperties;
import com.spring.restapi.models.SmsRequest;
import com.spring.restapi.models.Weather;
import com.spring.restapi.restclient.WeatherRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

//Twillio for Sms service
@Service
public class SmsService {
	private final TwillioProperties twillioProperties;
	@Autowired
	RestTemplate restTemp;
	@Autowired
	private WeatherRestClient restClient;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public SmsService(TwillioProperties twillioProperties) {
		super();
		this.twillioProperties = twillioProperties;
	}

	public String getMessageData() {
		/*
		 * ResponseEntity<String> messageResponse =
		 * restTemp.exchange("http://localhost:8091/getweather/", HttpMethod.GET, null,
		 * String.class);
		 */
		//ResponseEntity<String> messageResponse = restTemp.getForEntity("http://localhost:8091/getweather", String.class);
		//ResponseEntity<Weather> messageResponse = restTemp.getForEntity("http://WEATHERSERVICE/getweather", Weather.class);
		Weather message = restClient.getWeatherMessage();

		//String message = modelMapper.map(messageResponse, String.class);
		//Weather message = modelMapper.map(messageResponse, Weather.class);
		//System.out.println("before");
		//Weather message = messageResponse.getBody();
		System.out.println("after");
		String weatherMessage = message.toString();
		System.out.println(weatherMessage);
		return weatherMessage;
	}

	public String sendSms(String number) {
		System.out.println(number);
		Message message = Message.creator(new PhoneNumber(number),
				new PhoneNumber(twillioProperties.getFromNumber()), getMessageData()/*"Twillio msg"*/).create();
		System.out.println("send sms end\n");
		//ResponseEntity<String> data = getMessageData();
		//System.out.println(data);
		//getMessageData();
		return message.getStatus().toString();
		

	}

}
